<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
  <div class="col-md-3 mb-2 mb-md-0">
    <a href="/" class="d-inline-flex link-body-emphasis text-decoration-none">
      <svg class="bi" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
    </a>
  </div>

  <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
    <li><a href="${pageContext.request.contextPath}/" class="nav-link px-2 link-secondary">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/empList" class="nav-link px-2" >전체 사원 조회</a></li>
    <li><a href="${pageContext.request.contextPath}/empInsert" class="nav-link px-2" >사원 정보 등록</a></li>
    <li><a href="#" class="nav-link px-2">FAQs</a></li>
    <li><a href="#" class="nav-link px-2">About</a></li>
  </ul>

  <div class="col-md-3 text-end">
    <button type="button" class="btn btn-outline-primary me-2">Login</button>
    <button type="button" class="btn btn-primary">Sign-up</button>
  </div>
</header>