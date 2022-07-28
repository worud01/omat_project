package vo;

public class PageInfo {
	
	
	private int PageNum;
	private int maxPage;
	private int endPage;
	private int startPage;
	private int listCount;
	public PageInfo(int pageNum, int maxPage, int endPage, int startPage, int listCount) {
		super();
		PageNum = pageNum;
		this.maxPage = maxPage;
		this.endPage = endPage;
		this.startPage = startPage;
		this.listCount = listCount;
	}
	public int getPageNum() {
		return PageNum;
	}
	public void setPageNum(int pageNum) {
		PageNum = pageNum;
	}
	public int getMaxPage() {
		return maxPage;
	}
	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	

}
