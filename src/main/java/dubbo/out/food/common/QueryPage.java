/**
 * 
 */
package dubbo.out.food.common;

import java.io.Serializable;

/**
 * ��ѯ����
 * 
 * @author zph
 * @createTime 2017��3��13�� ����3:48:31
 * 
 */
public class QueryPage<T> implements Serializable {

	private static final long serialVersionUID = -4326726798615994946L;

	/**
	 * Ĭ��ҳ��������ʾ��С
	 */
	private Integer limit = Constants.PAGE_DEFAULT_LIMIT;
	/**
	 * Ĭ��ƫ����
	 */
	private Integer offset = Constants.PAGE_DEFAULT_OFFSET;
	/**
	 * ��ѯ���ݶ���
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
