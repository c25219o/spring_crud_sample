package jp.co.opst.spring.params;

import org.springframework.stereotype.Component;

@Component
public class Pager {

    private Integer currentPage;
    private String pagingAction;
    /**
     * @return the currentPage
     */
    public Integer getCurrentPage() {
        return currentPage;
    }
    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    /**
     * @return the pagingAction
     */
    public String getPagingAction() {
        return pagingAction;
    }
    /**
     * @param pagingAction the pagingAction to set
     */
    public void setPagingAction(String pagingAction) {
        this.pagingAction = pagingAction;
    }
}
