<template>
	<div class="container">
			<div>
				<label for="name">이름</label>
				<input type="text" v-model="user.name" />
			</div>
			<div>
				<label for="email">아이디</label>
				<input type="text" v-model="user.id" />
			</div>
			<div>
				<label for="password">비밀번호</label>
				<input type="password" v-model="user.pw" />
			</div>
			<div>
				<label for="passwordConfirm">비밀번호 확인</label>
				<input type="password" v-model="user.passwordConfirm" />
			</div>
			<div>
				<label for="nikname">비밀번호 확인</label>
				<input type="nikname" v-model="user.nikname" />
			</div>
			<div>
				<label for="email">email</label>
				<input type="text" v-model="user.email" />
			</div>
			<div>
				<label for="address">주소</label>
				<input type="text" v-model="user.address" />
			</div>
			<button @click="insert">회원가입</button>
	</div>
</template>

<script>
// import * as memberAPI from "@/apis/member";

export default {
  name: 'Home',
  data() {
    return {
      user:{
        // id:'',
        // email: '',
        // name: '',
        // password: '',
        // passwordConfirm: '',
        // position: '',
        // teamName: '',
      }
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
      console.log('user ::', this.user)
      this.$axios.post('/member/insert',this.user)
      .then(res => console.log(res))
      .catch(err => console.log(err))

      // memberAPI.insert(this.user)
      // .then(res => console.log(res))
      // .catch(err => console.log(err))
    }
  },
}
</script>
