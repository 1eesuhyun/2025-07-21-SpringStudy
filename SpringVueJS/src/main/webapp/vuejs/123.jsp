<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
   <style>
    .card-list {
      display: flex;
      gap: 10px;
      margin: 30px;
    }
    .card {
      border: 1px solid #ddd;
      border-radius: 6px;
      padding: 10px;
      width: 150px;
    }
    .card-title {
      font-weight: bold;
      margin-bottom: 5px;
    }
    .card-category {
      font-size: 12px;
      color: #666;
    }
  </style>
</head>
<body>
  <div id="app">
  	<div class="container">
  		<div class="card" v-for="talent in talents" :key="talent.id">
  		<div class="card-title">{{talent.title}}</div>
  		<div class="card-category">{{talent.category}}</div>
  	</div>
  	</div>
   </div>
   <script>
   		Vue.createApp({
   			data(){
   				return {
   					talents:[
   						{id:1,title:'ㅁㄴㅇㅁㄴㅇ',category:'가나다라'},
   						{id:2,title:'ㅁㄴㅇㅁ',category:'다라'},
   						{id:3,title:'ㅁㅁㄴㅇ',category:'가나'}
   					]
   				}
   			}
   	}).mount('#app')
   </script>
</body>
</html>
