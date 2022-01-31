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
              <span>
                <strong id="abc">1</strong>
              </span>
              /6
              <span>
                <button type="button" onclick="previousPage()"></button>
                <button type="button" onclick="nextPage()"></button>
              </span>
            </span>
          </div>
          <div id="pagination-div" class="wrap_con" id="listPage">
            <ul>
              <li>
                <label>
                  <img class="pictures" src="${choicePhoto}Add.jpg" />
                  <input
                    type="file"
                    id="addPhoto"
                    accept="image/gif, imeage/jpeg, image/png"
                    style="display: none"
                  />
                </label>
              </li>
            </ul>
            <div id="list1">
              <ul class="con on">
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}1-1.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}1-2.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}1-3.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}1-4.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}1-5.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}1-6.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}1-7.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
              </ul>
            </div>
            <div id="list2" style="display: none">
              <ul class="con">
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}2-1.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}2-2.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}2-3.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}2-4.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}2-5.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}2-6.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
                <li>
                  <a
                    ><img
                      class="pictures"
                      src="${choicePhoto}2-7.jpg"
                      onclick="imgChange(this.src)"
                  /></a>
                </li>
              </ul>
              <div id="list3" style="display: none">
                <ul class="con">
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}3-1.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}3-2.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}3-3.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}3-4.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}3-5.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}3-6.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}3-7.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                </ul>
              </div>
              <div id="list4" style="display: none">
                <ul class="con">
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}4-1.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}4-2.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}4-3.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}4-4.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}4-5.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}4-6.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}4-7.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                </ul>
              </div>
              <div id="list5" style="display: none">
                <ul class="con">
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}5-1.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}5-2.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}5-3.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}5-4.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}5-5.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}5-6.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}5-7.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                </ul>
              </div>
              <div id="list6" style="display: none">
                <ul class="con">
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}6-1.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}6-2.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}6-3.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}6-4.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}6-5.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}6-6.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                  <li>
                    <a
                      ><img
                        class="pictures"
                        src="${choicePhoto}6-7.jpg"
                        onclick="imgChange(this.src)"
                    /></a>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
        <div class="makeArea">
          <p class="makeText">모임이름과 사진은 개설 후에도 변경할 수 있어요</p>
        </div>
        <!-- <div id="target">
          target
          <input type="text" id="bbb" value="1234" />
        </div>
        <button type="button" onclick="test()">Obserber</button> -->
        <script>
          // 감지할 타겟
          //   var target = document.getElementById("abc");

          //   console.log("target :", target);

          //   // 변경을 감지했을 때 실행할 부분
          //   var observer = new MutationObserver((mutations) => {
          //     //   alert('값변경')
          //     mutations.forEach((item) => {
          //       console.log("item :", item);
          //     });
          //     let pageNo = Number(currentPage.innerText);
          //     console.log("페이지 변경", pageNo);

          //     showList();
          //     // hideList(pageNo);
          //   });

          //   // 감지 설정
          //   var config = {
          //     childList: true, // 타겟의 하위 요소 추가 및 제거 감지
          //     attributes: false, // 타켓의 속성 변경를 감지
          //     characterData: false, // 타겟의 데이터 변경 감지
          //     subtree: false, // 타겟의 자식 노드 아래로도 모두 감지
          //     attributeOldValue: false, // 타겟의 속성 변경 전 속성 기록
          //     characterDataOldValue: false, // 타겟의 데이터 변경 전 데이터 기록
          //   };

          //   // 감지 시작
          //   observer.observe(target, config);

          //   // 감지 종료
          //   observer.disconnect();

          let firstPage = 1;
          let lastPage = 6;
          //   let currentPage = document.getElementById("abc");
          let currentPage = Number($("#abc").text());

          function hideList() {
            // console.log(
            //   "hide page ",
            //   Number(page) + 1,
            //   document.getElementById("list" + [Number(page) + 1])
            // );
            // document.getElementById("list" + [Number(page) + 1]).style.display =
            //   "none";
            // document.getElementById("list" + [Number(page) - 1]).style.display =
            //   "none";
            document.getElementById(
              "list" + [currentPage.innerText]
            ).style.display = "none";
          }

          function showList() {
            console.log("showList " + currentPage);
            document.getElementById("list" + [currentPage]).style.display =
              "block";
          }
          function previousPage() {
            // console.log("previousPage ", currentPage.innerText);
            if (Number(currentPage.innerText) !== 1) {
              currentPage.innerText = currentPage.innerText - 1;
              //   hideList(Number(currentPage.innerText));
              hideList();
            }
          }
          async function nextPage() {
            if (currentPage !== 6) {
              //   currentPage.innerText = Number(currentPage.innerText) + 1;
              currentPage = currentPage + 1;
              $("#abc").change(currentPage);
              showList();
            }
            console.log("###", currentPage);
          }
        </script>
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
                </label>
                <span class="checkLabel">
                  <strong>모임명 공개 모임</strong>
                  <span class="msg">
                    누구나 모임을 검색으로 찾아 모임 소개를 볼 수 있지만,
                    게시글은 멤버만 볼 수 있습니다.
                  </span>
                </span>
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
                </label>
                <span class="checkLabel">
                  <strong>공개 모임</strong>
                  <span class="msg">
                    누구나 모임을 검색으로 찾을 수 있고, 모임 소개와 게시글을 볼
                    수 있습니다.
                  </span>
                </span>
              </li>
            </ul>
          </div>
        </div>
        <div class="btnArea">
          <button type="button" class="btnCancel">취소</button>
          <button type="submit" class="btnConfirm">완료</button>
        </div>
      </div>
    </form>
  </body>
</html>
