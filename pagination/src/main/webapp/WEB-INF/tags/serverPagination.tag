<%@ tag body-content="empty" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ attribute name="permanentParameters" required="true" rtexprvalue="true" type="java.lang.String" %>
<%@ attribute name="currentPage" required="true" rtexprvalue="true" type="java.lang.Integer" %>
<%@ attribute name="recordsPerPage" required="true" rtexprvalue="true" type="java.lang.Integer" %>
<%@ attribute name="pagesNum" required="true" rtexprvalue="true" type="java.lang.Integer" %>


<div class="container middle pagination">
    <ul class="pagination">
        <c:choose>
            <c:when test="${currentPage eq 1}">
                <li class="active leftChevron pagination"><a class="pagination" href="#"></a></li>
            </c:when>
            <c:otherwise>
                <li class="leftChevron pagination"><a class="pagination"
                                                      href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage-1}"></a>
                </li>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${pagesNum lt 10}">
                <c:forEach begin="1" end="${pagesNum}" var="i">
                    <c:choose>
                        <c:when test="${currentPage ne i}">
                            <li class="pagination"><a class="pagination"
                                                      href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="active pagination"><a class="pagination" href="#">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:when>
            <c:when test="${currentPage le 4}">
                <c:forEach begin="1" end="7" var="i">
                    <c:choose>
                        <c:when test="${currentPage ne i}">
                            <li class="pagination"><a class="pagination"
                                                      href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="active pagination"><a class="pagination" href="#">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <li class="dots pagination"><a class="pagination" href="#"></a></li>
                <li class="pagination"><a class="pagination"
                                          href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${pagesNum}">${pagesNum}</a>
                </li>
            </c:when>
            <c:when test="${pagesNum - currentPage lt 4}">
                <li class="pagination"><a class="pagination"
                                          href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=1">1</a>
                </li>
                <li class="dots pagination"><a class="pagination" href="#"></a></li>
                <c:forEach begin="${pagesNum-6}" end="${pagesNum}" var="i">
                    <c:choose>
                        <c:when test="${currentPage ne i}">
                            <li class="pagination"><a class="pagination"
                                                      href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="active pagination"><a class="pagination" href="#">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <li class="pagination"><a class="pagination"
                                          href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=1">1</a>
                </li>
                <li class="dots pagination"><a class="pagination" href="#"></a></li>
                <c:forEach begin="${currentPage-2}" end="${currentPage+2}" var="i">
                    <c:choose>
                        <c:when test="${currentPage ne i}">
                            <li class="pagination"><a class="pagination"
                                                      href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${i}">${i}</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="active pagination"><a class="pagination" href="#">${i}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <li class="dots pagination"><a class="pagination" href="#"></a></li>
                <li class="pagination"><a class="pagination"
                                          href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${pagesNum}">${pagesNum}</a>
                </li>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${currentPage eq pagesNum}">
                <li class="active rightChevron pagination"><a class="pagination" href="#"></a></li>
            </c:when>
            <c:otherwise>
                <li class="rightChevron pagination"><a class="pagination"
                                                       href="${permanentParameters}&recordsPerPage=${recordsPerPage}&currentPage=${currentPage+1}"></a>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>


    <label for="selectRecordsPerPage" class="selectRecordsPerPage">
        Records per page:
        <select id="selectRecordsPerPage" onchange="document.location=this.options[this.selectedIndex].value">
            <c:set var="recordsPerPageList" value="${[5,10,15]}"/>
            <c:forEach var="recordsPerPageItem" items="${recordsPerPageList}">
                <c:choose>
                    <c:when test="${recordsPerPageItem eq recordsPerPage}">
                        <option selected hidden>${recordsPerPage}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${permanentParameters}&recordsPerPage=${recordsPerPageItem}&currentPage=1">
                                ${recordsPerPageItem}
                        </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </label>
</div>



