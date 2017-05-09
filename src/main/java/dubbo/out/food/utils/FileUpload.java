package dubbo.out.food.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemHeaders;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * commons-fileupload
 * 
 * @author liuwei
 *
 */
public class FileUpload {
	private final static Logger log = Logger.getLogger(FileUpload.class);

	/**
	 * 获取表单参数
	 * 
	 * @param request
	 * @param key
	 * @return
	 */
	public static String getParam(List<FileItem> items, String key) {
		String param = null;
		try {
			for (FileItem item : items) {
				// 表单�?
				if (item.isFormField()) {
					if (item.getFieldName().equals(key)) {
						param = item.getString();
					}
					if (StringUtils.isNotEmpty(param)) {
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return param;
	}

	/**
	 * request change
	 * 
	 * @param request
	 * @param maxSizeLimit
	 *            �?大上传限�? 10m == > 1024 * 1024 * 10
	 * @return
	 */
	public static List<FileItem> parseRequest(HttpServletRequest request,
			long maxSizeLimit) {
		Progress p = new Progress();
		// 设置上传文件总大�?
		p.setLength(request.getContentLength());
		log.info("-> file total size : " + p.getLength());
		// 上传临时路径
		String path = System.getProperty("java.io.tmpdir");
		log.info("-> file temp dir(when file total size over 2M) : " + path);
		// 设置上传工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(new File(path));
		// �?�?,超过这个值才会写到临时目�? 2M
		factory.setSizeThreshold(1024 * 1024 * 2);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		// �?大上传限�?
		upload.setSizeMax(maxSizeLimit);
		// 设置监听器监听上传进�?
		upload.setProgressListener(p);
		List<FileItem> items = null;
		try {
			log.info("-> parse request....");
			items = upload.parseRequest(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return items;
	}

	/**
	 * 校验结果 ok-通过校验，more-超过�?大�?�，less-无效文件，fail-校验出错
	 * 
	 * @author liuwei3
	 */
	public enum Limit {
		ok, more, less, fail
	}

	public static Limit uploadCheck(HttpServletRequest request,
			long maxSizeLimit) {
		Limit checkResult = Limit.ok;
		try {
			if (request.getContentLength() <= 0) {
				log.debug("-> upload false -> file total size 0 byte");
				checkResult = Limit.less;
			}
			if (request.getContentLength() > maxSizeLimit) {
				log.debug("-> upload false -> file total size over "
						+ maxSizeLimit + " byte");
				checkResult = Limit.more;
			}
		} catch (Exception e) {
			e.printStackTrace();
			checkResult = Limit.fail;
		}
		return checkResult;
	}

	/**
	 * 单文件上�?
	 * 
	 * @param request
	 * @param file
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> upload(List<FileItem> items,
			File fileDir, String fieldNamePrefix, String fileName) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean uploadState = false;
		try {
			log.info("-> progress upload file....");
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			for (FileItem item : items) {
				// 非表单域
				if (!item.isFormField()
						&& item.getFieldName().startsWith(fieldNamePrefix)) {
					log.info("-> file save path  : " + fileDir.getPath()
							+ " -> " + item.getName());
					String suffix = item.getName().substring(
							item.getName().lastIndexOf("."));
					if (StringUtils.isNotEmpty(suffix) && suffix.length() > 1) {
						fileName = fileName + suffix;
						result.put("fileName", fileName);
						FileOutputStream fos = new FileOutputStream(new File(
								fileDir, fileName));
						// 文件全在内存�?
						if (item.isInMemory()) {
							fos.write(item.get());
						} else {
							InputStream is = item.getInputStream();
							byte[] buffer = new byte[1024];
							int len;
							while ((len = is.read(buffer)) > 0) {
								fos.write(buffer, 0, len);
							}
							is.close();
						}
						fos.close();
						log.info("->upload complete");

						item.delete();
						log.info("->delete temp file");

						uploadState = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		result.put("uploadState", uploadState);
		return result;
	}
	

	/**
	 * 上传文件进度信息
	 * 
	 * @author liuwei3
	 */
	public static class Progress implements ProgressListener {
		// 文件总长�?
		private long length = 0;
		// 已上传的文件长度
		private long currentLength = 0;
		// 上传是否完成
		private boolean isComplete = false;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.apache.commons.fileupload.ProgressListener#update(long,
		 * long, int)
		 */
		@Override
		public void update(long bytesRead, long contentLength, int items) {
			this.currentLength = bytesRead;
			if (length > 0 && currentLength == length) {
				setComplete(true);
				log.info("->update Progress object complete");
			}
		}

		/**
		 * the getter method of length
		 * 
		 * @return the length
		 */
		public long getLength() {
			return length;
		}

		/**
		 * the getter method of currentLength
		 * 
		 * @return the currentLength
		 */
		public long getCurrentLength() {
			return currentLength;
		}

		/**
		 * the getter method of isComplete
		 * 
		 * @return the isComplete
		 */
		public boolean isComplete() {
			return isComplete;
		}

		/**
		 * the setter method of the length
		 * 
		 * @param length
		 *            the length to set
		 */
		public void setLength(long length) {
			this.length = length;
		}

		/**
		 * the setter method of the currentLength
		 * 
		 * @param currentLength
		 *            the currentLength to set
		 */
		public void setCurrentLength(long currentLength) {
			this.currentLength = currentLength;
		}

		/**
		 * the setter method of the isComplete
		 * 
		 * @param isComplete
		 *            the isComplete to set
		 */
		public void setComplete(boolean isComplete) {
			this.isComplete = isComplete;
		}
	}
}
