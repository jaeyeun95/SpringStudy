<template>
	<div class="container">
			<table>
        <tr>
          <td>이름</td>
          <td>
              <input type="text" v-model="user.name" />
          </td>
        </tr>
        <tr>
          <td>아이디</td>
          <td>
              <input type="text" v-model="user.id" />
          </td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td>
              <input type="password" v-model="user.pw" />
          </td>
        </tr>
        <tr>
          <td>비밀번호 확인</td>
          <td>
              <input type="password" v-model="user.passwordConfirm" />
          </td>
        </tr>
        <tr>
          <td>닉네임</td>
          <td>
              <input type="nickname" v-model="user.nickname" />
          </td>
        </tr>
        <tr>
          <td>email</td>
          <td>
              <input type="text" v-model="user.email" />
          </td>
        </tr>
        <tr>
          <td>주소</td>
          <td>
              <button @click="showApi">주소검색</button>
          </td>
        </tr>
        <tr>
          <td colspan="3">
              <div ref="embed"></div> <!-- api UI 나오는 공간, 나중엔 모달로 -->
              <span>우편주소 : <input type="text" v-model="user.zipCode"/></span> <br>
              <span>기본주소 : <input type="text" v-model="addr1"/></span> <br>
              <span>상세주소 : <input type="text" v-model="addr2"/> </span>
          </td>
        </tr>
      </table>
			<button @click="insert">회원가입</button>
	</div>
</template>

<script>
// import * as memberAPI from "@/apis/member";

export default {
  name: 'Home',
  data() {
    return {
      user:{},
      // zip:'',
      addr1:'',
      addr2:'',
    }
  },
  components: {
  },
  methods: {
    insert(){
      // const headers = {
      //   'Content-type': 'application/json; charset=UTF-8',
      // }
      // console.log('user ::', this.user, headers)
      this.user.address = this.addr1 + this.addr2;
      console.log('user ::', this.user)
      this.$axios.post('/member/insert',this.user)
      .then(res => console.log(res))
      .catch(err => console.log(err))

      // memberAPI.insert(this.user)
      // .then(res => console.log(res))
      // .catch(err => console.log(err))
    },
    showApi(){
      new window.daum.Postcode({ oncomplete: (data) => { 
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 

        // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다. 
        let fullRoadAddr = data.roadAddress;  // 도로명 주소 변수 
        let extraRoadAddr = ''; // 도로명 조합형 주소 변수 
        
        // 법정동명이 있을 경우 추가한다. (법정리는 제외) 
        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다. 
        if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){ 
            extraRoadAddr += data.bname; } 
        // 건물명이 있고, 공동주택일 경우 추가한다. 
        if(data.buildingName !== '' && data.apartment === 'Y'){ 
            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName); } 
            
        // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다. 
        if(extraRoadAddr !== ''){ 
            extraRoadAddr = ' (' + extraRoadAddr + ')'; 
        } 
        // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다. 
        if(fullRoadAddr !== ''){ 
            fullRoadAddr += extraRoadAddr; 
        } 
        // 우편번호와 주소 정보를 해당 필드에 넣는다. 
        this.user.zipCode = data.zonecode; //5자리 새우편번호 사용 
        this.addr1 = fullRoadAddr; 
        } 
        }).embed(this.$refs.embed)

    }
  },
}
</script>
