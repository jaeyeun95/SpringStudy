<template>
    <div>
        <!-- <table>
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
                <td>email</td>
                <td>
                    <input type="text" v-model="user.email" />
                </td>
            </tr>
            <tr>
                <td>주소</td>
                <td>
                    <button @click="showApi">검색</button>
                    <div ref="embed"></div> 
                    <span>우편주소 : <input type="text" v-model="user.zipCode"/></span> <br>
                    <span>기본주소 : <input type="text" v-model="addr1"/></span> <br>
                    <span>상세주소 : <input type="text" v-model="addr2"/> </span>
                </td>
            </tr>
        </table> -->


        <!-- <h1>주소</h1>
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
				<label for="address">주소</label> <button @click="showApi">검색</button>
                <div ref="embed"></div> 
                <span>우편주소 : <input type="text" v-model="user.zipCode"/></span> <br>
                <span>기본주소 : <input type="text" v-model="addr1"/></span> <br>
				<span>상세주소 : <input type="text" v-model="addr2"/> </span>
			</div>
			<button @click="insert">회원가입</button>
        </div> -->

        <h1>sample</h1>

    </div>
</template>
<script>
export default {
    name:"Sample",
    created() {
        this.getList();
    },
    methods: {
        getList(){
            this.$axios.post('/member/list')
            .then(res => console.log(res))
            .catch(err => console.log(err))
        }
    },
    
}
</script>
<style >
    
</style>