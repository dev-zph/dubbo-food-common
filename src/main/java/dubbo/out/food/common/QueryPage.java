/**
 * 
 */
package dubbo.out.food.common;

import java.io.Serializable;

/**
 * 查询对象
 * 
 * @author zph
 * @createTime 2017年3月13日 下午3:48:31
 * 
 */
public class QueryPage<T> implements Serializable {

	private static final long serialVersionUID = -4326726798615994946L;

	/**
	 * 默认页面数据显示大小
	 */
	private Integer limit = Constants.PAGE_DEFAULT_LIMIT;
	/**
	 * 默认偏移量
	 */
	private Integer offset = Constants.PAGE_DEFAULT_OFFSET;
	/**
	 * 查询数据对象
	 */
	private T condition;

	public QueryPage() {
	}


	/**
	 * @param limit
	 * @param offset
	 */
	public QueryPage(Integer limit, Integer offset) {
		if (null != limit) {
			this.limit = limit;
		}
		if (null != offset) {
			this.offset = offset;
		}
	}


	/**
	 * @param limit
	 * @param offset
	 * @param condition
	 */
	public QueryPage(Integer limit, Integer offset, T condition) {
		super();
		if (null != limit) {
			this.limit = limit;
		}
		if (null != offset) {
			this.offset = offset;
		}
		this.condition = condition;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public T getCondition() {
		return condition;
	}

	public void setCondition(T condition) {
		this.condition = condition;
	}
}
