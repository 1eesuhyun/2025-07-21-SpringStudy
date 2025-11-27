<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container {
	margin-top: 50px;
}

.row {
	margin: 0px auto;
	width: 800px;
}
</style>
</head>
<body>
<div class="container">
  <h1 class="row">Vue 생명주기(생성~소멸)</h1>
  <div class="row">
   입력:<input type=text size=30 class="input-sm" v-model="msg">
   <p>
    {{msg}}
   </p>
 </div>
</div>
<script>
	let a=Vue.createApp({
		// Model => 데이터 관리
		// data()안에 있는 변수가 변경이 되면 바로 HTML에 적용
		/*
			설정 변수
			정수
			no:0,
			no:0.0,
			bCheck:false,
			msg:'',
			detail:{} => VO단위
			list:[]=> List단위
		*/
		data(){
			return{
			msg:''
			}
		},
		beforeCreate(){
			console.log("Vue객체 생성 전 : beforeCreate() Call")	
			// comonentWillCreate()
		},
		created(){
			console.log("Vue객체 생성 완 : created() Call")			
			// componentDidCreate()
		},
		beforemount(){
			console.log("브라우저에 화면 출력 전 : beforemount() Call")
			// componentWillMount()
		},
		mounted(){
			console.log("***********브라우저 화면 출력 완 : mounted() Call")
			// $(function()), window.onload
			// componentDidMount()
		},
		beforeUpdate(){
			console.log("데이터 변경 전 : beforeUpdate() Call")
			// componentWillupdate()
		},
		updated(){
			console.log("데이터 변경 완 :updated() Call")
			// componentDidupdated()
		},
		// beforeDestroy()
		beforeUnmount(){
			console.log("화면 이동 전 : beforeUnmount() Call")
			// componemtWillUnmount()
		},
		unmounted(){
			console.log("화면 이동 완 : Vue 객체 소멸 : unmounted() Call")
			// componentDidUnmounted()
		},
		/*
		methods:{
			// 사용자 정의 함수
		},
		components:{
			// 화면안에 다른 화면을 띄운다
		},
		computed:{
			
		},
		watch:{
			// 컴포넌트가 변경이 될 때마다 호출
		}
		*/
	}).mount('.container')
</script>
</body>
</html>