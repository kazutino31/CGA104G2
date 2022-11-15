<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>storeIndex.jsp</title>
   <style type="text/css">
        .header {
            border-bottom: 1px solid #ccc;
            margin-bottom: 5px;
        }

        #title {
            /* border: 1px solid black; */
            display: inline-block;
            width: 100%;
            color: red;
            text-align: center;
        }

        .MainContainer {
            min-width: 960px;
            max-width: 1600px;
        }

        .sidebar {
            width: 20%;
            float: left;
            margin-right: -180px;
            border-right: 1px solid #ccc;
            min-height: 500px;
            padding: 5px;
            
        }
        .li li{
        	list-style: none;
        }
		
        .main {
            float: left;
            margin-left: 200px;
            padding: 5px;
        }

        .content {
            padding: 0 10px;
        }

        #main {
            display: inline-block;
            width: 75%;
            height: 490px;
            border: 1px solid red;

        }
    </style>
    <style>
	  table#table-1 {
		background-color: #CCCCFF;
	    border: 2px solid black;
	    text-align: center;
	  }
	  table#table-1 h4 {
	    color: red;
	    display: block;
	    margin-bottom: 1px;
	  }
	  h4 {
	    color: blue;
	    display: inline;
		  }
	</style>

	<style>
	  #getStoreAll {
	  	border: 1px solid #CCCCFF;
		width: 800px;
		background-color: white;
		margin-top: 5px;
		margin-bottom: 5px;
	  }
	  #getStoreAll th  {
	    border: 1px solid #CCCCFF;
	    padding: 5px;
	    text-align: center;
	  }
	  #getStoreAll td {
	   	border: 1px solid #CCCCFF;
	    padding: 5px;
	    text-align: center;
	  }

	</style>
</head>
<body>
    <div class="page">

        <div class="header">
            <div id="title">
                <h1>特約商店系統</h1>
            </div>
        </div>

        <div class="MainContainer">
            <div class="sidebar">
                <ul>
                    <li class="li">特約商店管理
                        <ol>
                            <li>
                            	<input type="button" id="addStore" value="新增商店">
                            </li>
                            
                            <li>
                            	<input type="hidden" name="action" value="getAll">
                            	<input type="submit" id="listAllMail" value="所有特約商店">
                            </li>
                        </ol>
                    </li>
                </ul>
            </div>

            <div id="main" class="main">

            </div>

        </div>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <script>
    	
	    window.addEventListener("load", function () {
	        document.getElementById("addStore").onclick = showAddStore;
	    }, false);
	   
	    window.addEventListener("load", function () {
	        let listAllMail = document.getElementById("listAllMail").onclick = getStore;
	    }, false);
    
//     =====================================顯示AddStore=============================================
		 function showAddStore(){
        	let addStore = "<form action='store.do' method='post' enctype='multipart/form-data'>"
        	+"<table class='content'>"
        	+"<tr><td>商店項目編號:</td><td><input type='text' name='storeTypeId' value='1'></td></tr>"
        	+"<tr><td>商店位置:</td><td><input type='text' id='storeLoc' name='storeLoc' value='桃園市中壢區'></td></tr>"
        	+"<tr><td>商店經度:</td><td><input type='text' name='storeLon' value='0.99999'></td></tr>"
        	+"<tr><td>商店緯度:</td><td><input type='text' name='storeLat' value='0.99999'></td></tr>"
        	+"<tr><td>商店圖片:</td><td><input id='photo' type='file' name='storePhoto' width='150px' height='100px'></td></tr>"
        	+"<tr><td></td><td><img id=img width='150px' height='100px'></td></tr>"
        	+"<tr><td>商店內容:</td><td><textarea name='storeInfo' rows='10px' cols='30px'>餐廳餐廳餐廳餐廳餐廳餐廳餐廳餐廳餐廳餐廳</textarea></td></tr>"
        	+"<tr><td><input type='hidden' name='action' value='insert'></td></tr>"
        	+"<tr><td><button id='add' type='submit' value='資料送出'>資料送出</button></td></tr></form>";
        	document.getElementById("main").innerHTML = addStore;
        	
        	 $('#photo').change(function(event) {
    				const file = this.files[0];
    				const objectURL = URL.createObjectURL(file);
    				 
    				$('#img').attr('src', objectURL);
    			});
    			
		 }
//	     =====================================預覽圖片=============================================		
		
        //=====================================顯示getAll=============================================
       	 function showStore(json){
        	let store = JSON.parse(json);
        	let str = "<table id= 'getStoreAll'>"
        	+ "<tr id='tr'><th>商店編號</th><th>商店項目編號</th><th>商店內容</th><th>商店位置</th><th>商店經度</th><th>商店緯度</th><th>商店圖片</th><th>修改</th><th>刪除</th></tr>"
        	+ "</table>";
			document.getElementById("main").innerHTML = str;
			
        	for(let i = 0; i < store.length ; i++){
        		let str = null;
            	str+= "<tr><td>" + store[i].storeId + "</td>"
            	+"<td>" + store[i].storeTypeId + "</td>"
            	+"<td>" + store[i].storeInfo + "</td>"
            	+"<td>" + store[i].storeLoc + "</td>"
            	+"<td>" + store[i].storeLon + "</td>"
            	+"<td>" + store[i].storeLat + "</td>"
            	+"<td id='prePhoto'><img width='150px' height='100px'src=data:image/jpeg;base64,"+ store[i].base64img +"></td>"
				+"<td><form action='store.do' method='POST' enctype='multipart/form-data'>"
				+"<input type='submit' value='修改'>"
				+"<input type='hidden' name='storeId' value='"+ store[i].storeId +"'>"
				+"<input type='hidden' name='action' value='getOne_For_Update'></td></form>"
	        	+"<td><input type='button' id='delete' value='刪除'></td></tr>";
            	$("#tr").after(str); 
            	//=====================================預覽圖片=============================================
            		   	   	
            	//=====================================刪除按鈕=============================================
            	let actionDelete = document.getElementById("delete");
            	actionDelete.addEventListener("click", function(){
            		let flag = confirm("你確定要刪除嗎？");
            		if(flag){
            			let xhr = new XMLHttpRequest();
                		//建立好Post連接
            	        xhr.open("get", "<%= request.getContextPath()%>/back-end/store/store.do?action=delete&storeId="+ store[i].storeId , true);
            	        xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
            	        //送出請求
            	        xhr.send();
//             	        window.location.reload(); 
//             	        getStore();
            	        }
            	});            	
        	}    	
        }
        	
       	
        function getStore(){
            let xhr = new XMLHttpRequest();
            
            xhr.onload = function(){
                if(xhr.status == 200){
                       showStore(xhr.responseText);
                }else{
                    alert(xhr.status);
                }
            };
          //建立好Post連接
	        xhr.open("get", "/CGA104G2/back-end/store/store.do?action=getAll", true);
	        xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	        //送出請求
	        xhr.send();
        };
         
       
    </script>
</body>
</html>