package dubbo.out.food.common;

import java.util.List;

/**
 * @author zhangph
 * @version 2017-07-06 15:05
 **/
public class ResponsePage <T> extends Response {

    private static final long serialVersionUID = -782517319727493071L;
    /**
     * 默认页面数据显示大小
     */
    private Integer limit;
    /**
     * 默认偏移量
     */
    private Integer offset;
    /**
     * 数据总量
     */
    private Long total;

    public ResponsePage() {
    }

    /**
     * @param limit
     * @param offset
     * @param total
     */
    public ResponsePage(Integer limit, Integer offset, long total) {
        super();
        this.limit = limit;
        this.offset = offset;
        this.total = total;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public void setData(List data) {
        super.setData(data);
    }


    public ResponsePage<T> success() {
        this.setCode(ResultCode.RESULT_SUCCESS.getCode());
        return this;
    }
}