<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="com.web.home.clubCreate.model.*" %> <%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib
prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link href="resources/css/club/clubCreate.css" rel="stylesheet" />
    <script
      type="text/javascript"
      src="/resources/js/jquery-3.6.0.min.js"
    ></script>
    <!--<script type="text/javascript" src="/resources/js/clubCreate.js"></script>-->
    <title>모임 만들기</title>
  </head>

  <body>
    <form action="./clubCreate" method="POST" enctype="multipart/form-data">
      <div class="coverMain">
        <c:url var="choicePhoto" value="resources/img/club/insert/download" />
        <div class="mainName">
          <h4>모임이름</h4>
          <input
            type="text"
            name="name"
            class="clubName"
            maxlength="50"
            placeholder="모임 이름 입력"
          />
        </div>
        <div class="select_img">
          <img
            id="photo"
            src="${choicePhoto}1-1.jpg"
            width="300"
            height="225"
          />
        </div>
        <div class="coverList">
          <div class="coverChoice">
            <h4>커버 선택</h4>
            <span class="paging">
              <strong id="abc">1</strong>
              /6
              <span>
                <button
                  type="button"
                  id="previousPage2"
                  onclick="previousPage()"
                ></button>
                <button
                  type="button"
                  id="nextPage3"
                  onclick="nextPage()"
                ></button>
              </span>
            </span>
          </div>
          <script>
            console.log();
            var firstPage = 1;
            var lastPage = 6;
            let currentPage = document.getElementById("abc");
            function hideList() {
              document.getElementById(
                "list" + [currentPage.innerText]
              ).style.display = "none";
            }

            function showList() {
              document.getElementById(
                "list" + [currentPage.innerText]
              ).style.display = "block";
            }
            function previousPage() {
              if (Number(currentPage.innerText) !== 1) {
                hideList();
                currentPage.innerText = Number(currentPage.innerText) - 1;
                showList();
              }
            }
            function nextPage() {
              if (Number(currentPage.innerText) !== 6) {
                hideList();
                currentPage.innerText = Number(currentPage.innerText) + 1;
                showList();
              }
            }
          </script>
          <div id="pagination-div" class="wrap_con" id="listPage">
            <div id="list1">
              <ul class="con on">
                <li>
                  <h2>1페이지</h2>
                </li>
              </ul>
            </div>
            <div id="list2" style="display: none">
              <ul class="con">
                <li><h2>2페이지</h2></li>
              </ul>
            </div>
            <div id="list3" style="display: none">
              <ul class="con">
                <li><h2>3페이지</h2></li>
              </ul>
            </div>
            <div id="list4" style="display: none">
              <ul class="con">
                <li><h2>4페이지</h2></li>
              </ul>
            </div>
            <div id="list5" style="display: none">
              <ul class="con">
                <li><h2>5페이지</h2></li>
              </ul>
            </div>
          </div>
          <div id="list6" style="display: none">
            <ul class="con">
              <li><h2>6페이지</h2></li>
            </ul>
          </div>
        </div>
      </div>
      <div class="makeArea">
        <p class="makeText">모임이름과 사진은 개설 후에도 변경할 수 있어요</p>
      </div>
      <script>
        $("#addPhoto").change(function (e) {
          if (this.files && this.files[0]) {
            var reader = new FileReader();
            reader.onload = function (data) {
              $(".select_img img")
                .attr("src", data.target.result)
                .width(300)
                .height(225);
            };
            reader.readAsDataURL(this.files[0]);
          }
        });

        function imgChange(src) {
          document.getElementById("photo").src = src;
        }
      </script>
      <div class="makeType">
        <h4 class="title">밴드 공개</h4>
        <div class="clubType">
          <ul class="typeList">
            <li class="typeListItem">
              <label for="closed" class="checkbox">
                <input
                  type="radio"
                  value="n"
                  name="open"
                  id="n"
                  class="checkInput"
                />
                <span class="checkLabel">
                  <strong>모임명 공개 모임</strong>
                  <span class="msg">
                    누구나 모임을 검색으로 찾아 모임 소개를 볼 수 있지만,
                    게시글은 멤버만 볼 수 있습니다.
                  </span>
                </span>
              </label>
            </li>
            <li class="typeListItem">
              <label for="public" class="checkbox">
                <input
                  type="radio"
                  value="y"
                  name="open"
                  id="y"
                  class="checkInput"
                />
                <span class="checkLabel">
                  <span class="text">
                    <strong>공개 모임</strong>
                    <span class="msg">
                      누구나 모임을 검색으로 찾을 수 있고, 모임 소개와 게시글을
                      볼 수 있습니다.
                    </span>
                  </span>
                </span>
              </label>
            </li>
          </ul>
        </div>
      </div>
      <div>
        <button type="button" class="btnCancel">취소</button>
        <button type="submit" class="btnConfirm">완료</button>
      </div>
    </form>
  </body>
</html>
