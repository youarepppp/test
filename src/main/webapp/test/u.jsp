<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>INSPINIA | Wizards</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/plugins/steps/jquery.steps.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
	<link href="css/plugins/chosen/chosen.css" rel="stylesheet">
	<link href="css/plugins/awesome-bootstrap-checkbox/awesome-bootstrap-checkbox.css" rel="stylesheet">
	<link href="css/common.css" type="text/css" rel="stylesheet">
	<link href="css/index.css" type="text/css" rel="stylesheet">

    <style>

        .wizard > .content > .body  position: relative; }

    </style>

</head>

<body>

    <div id="wrapper">
<div class="ibox-content">
                            <h2>
                                注册
                            </h2>
                            <p>
                                用户支付后填写相关信息，完成注册。
                            </p>
<form id="form"  enctype="multipart/form-data" action="/test/test/u" class="wizard-big" method="post" onsubmit="" >
                                <h1>订单信息</h1>
                                <fieldset>
                                    <h2>订单信息填写</h2>
                                    <div class="row">
                                        <div class="col-lg-8">
                                            <div class="form-group"> 
                                                <label>用户名 *</label>
                                                <input id="userName" name="userName" type="text" class="form-control required">
                                            </div>
											<div class="form-group">
                                                <label>淘宝订单号 *</label>
                                                <input id="orderId" name="orderId" type="text" class="form-control required">
                                            </div>
											<div class="form-group">
                                                <label>联系手机号 *</label>
                                                <input id="mobile" name="mobile" type="text" class="form-control required">
                                            </div>
											<!--
                                            <div class="form-group">
                                                <label>Password *</label>
                                                <input id="password" name="password" type="text" class="form-control required">
                                            </div>
                                            <div class="form-group">
                                                <label>Confirm Password *</label>
                                                <input id="confirm" name="confirm" type="text" class="form-control required">
                                            </div>
											-->
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="text-center">
                                                <div style="margin-top: 20px">
                                                    <i class="fa fa-sign-in" style="font-size: 180px;color: #e5e5e5 "></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </fieldset>
                                <h1>申请资料</h1>
                                <fieldset>
                                    <h2>小程序申请相关资料</h2>
                                    <div class="row">

                                        <div class="col-lg-8">
											<div class="form-group">
											<div><label>企业类型 *</label></div>
														<div class="radio radio-info radio-inline">
															<input type="radio" id="inlineRadio1" value="1" name="radioInline" checked="">
															<label for="inlineRadio1"> 企业 </label>
														</div>
														<div class="radio radio-inline">
															<input type="radio" id="inlineRadio2" value="2" name="radioInline">
															<label for="inlineRadio2"> 个体工商户 </label>
														</div>
													</div>
                                            <div class="form-group" id="zj">
                                                <label>证件照片 *
													<input type='button' value='上传' onclick='haa()' class="ladda-button ladda-button-demo btn btn-primary"  data-style="zoom-in"></input>
												</label>
												<!--
												<label title="Upload image file" for="inputImage" class="btn btn-primary">
													<input type="file" name="zj" id="zj" accept="image/*" capture="camera" onchange ="upIamge(this,'zj_iamge','zj_view');" class="form-control required">
													
												</label>
												-->
												<div class="z_photo upimg-div clear" >
												<section class="z_file fl">
																		<img src="img/a11.png" class="add-img">
																		<input type="file"  capture="camera" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
																	 </section>
																	 </div>
												<aside class="mask works-mask">
														<div class="mask-content">
															<p class="del-p ">您确定要删除作品图片吗？</p>
															<p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
														</div>
												</aside>

                                            </div>
											<div class="form-group" id="zj_view">
                                                <!--<canvas id="zj_view"></canvas>-->
						

                                            </div>
                                
                                        </div>
										<!--
                                        <div class="col-lg-6">
                                            <div class="form-group">
                                                <label>Email *</label>
                                                <input id="email" name="email" type="text" class="form-control required email">
                                            </div>
                                            <div class="form-group">
                                                <label>Address *</label>
                                                <input id="address" name="address" type="text" class="form-control">
                                            </div>
                                        </div>
										-->
                                    </div>
                                </fieldset>

                                <h1>门店展示</h1>
                                <fieldset>
                                    <div class="row">
                                        <div class="col-lg-8">
                                            <div class="form-group">
                                                <label>附近小程序列表展示名称 *</label>
                                                <input id="userName2" name="userName2" type="text" class="form-control required">
                                            </div>
											<div class="form-group">
                                                <label>营业时间 *</label>
                                                <input id="orderId2" name="orderId2" type="text" class="form-control required">
                                            </div>
											<div class="form-group">
                                                <label>门店照片 *</label>
                                                <input type="file" name="cover" accept="image/*" capture="camera">
                                            </div>
										
                                        </div>
                                        <div class="col-lg-4">
                                            <div class="text-center">
                                                <div style="margin-top: 20px">
                                                    <i class="fa fa-sign-in" style="font-size: 180px;color: #e5e5e5 "></i>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </fieldset>

                                <h1>提交成功</h1>
                                <fieldset>
                                    <h2>注册成功了</h2>
                                    
                                </fieldset>
                            </form>
							 </div>

	       </div>



    <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <!-- Steps -->
    <script src="js/plugins/staps/jquery.steps.min.js"></script>

    <!-- Jquery Validate -->
    <script src="js/plugins/validate/jquery.validate.min.js"></script>

	<script src="js/imgUp.js"></script>
    <script>
    var myArray=new Array();
    function haa(){
    	
    	 var zj = document.getElementById("zj");
    	 alert(myArray.length);
    	 var formdata = new FormData();
    	 for(var i = 0;i<myArray.length;i++){
    		 formdata.append("file",myArray[i]);
    	 }
    	 
		 
		 var request = new XMLHttpRequest();
		 request.addEventListener("load", function(e){
	    		alert("上传成功");
		    }, false);  
		 
		 request.open("POST", "/test/test/upload.do");
		 request.send(formdata);
    	 
    	 
    }
    
	function test(){
		
		
		alert($("#taglocations").val());
		$.ajax({
            type: "POST",
            url: "/test/test/ttt",
            data: { imgPath: $("#file").val() },
            cache: false,
            success: function(data) {
            	alert(111);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert("上传失败，请检查网络后重试");
            }
        });

	}


        $(document).ready(function(){
            $("#wizard").steps();
            $("#form").steps({
                bodyTag: "fieldset",
                onStepChanging: function (event, currentIndex, newIndex)
                {
                    // Always allow going backward even if the current step contains invalid fields!
                    if (currentIndex > newIndex)
                    {
                        return true;
                    }

                    // Forbid suppressing "Warning" step if the user is to young
                    if (newIndex === 3 && Number($("#age").val()) < 18)
                    {
                        return false;
                    }

                    var form = $(this);

                    // Clean up if user went backward before
                    if (currentIndex < newIndex)
                    {
                        // To remove error styles
                        $(".body:eq(" + newIndex + ") label.error", form).remove();
                        $(".body:eq(" + newIndex + ") .error", form).removeClass("error");
                    }

                    // Disable validation on fields that are disabled or hidden.
                    form.validate().settings.ignore = ":disabled,:hidden";

                    // Start validation; Prevent going forward if false
                    return form.valid();
                },
                onStepChanged: function (event, currentIndex, priorIndex)
                {
                    // Suppress (skip) "Warning" step if the user is old enough.
                    if (currentIndex === 2 && Number($("#age").val()) >= 18)
                    {
                        $(this).steps("next");
                    }

                    // Suppress (skip) "Warning" step if the user is old enough and wants to the previous step.
                    if (currentIndex === 2 && priorIndex === 3)
                    {
                        $(this).steps("previous");
                    }
                },
                onFinishing: function (event, currentIndex)
                {
                    var form = $(this);

                    // Disable validation on fields that are disabled.
                    // At this point it's recommended to do an overall check (mean ignoring only disabled fields)
                    form.validate().settings.ignore = ":disabled";

                    // Start validation; Prevent form submission if false
                    return form.valid();
                },
                onFinished: function (event, currentIndex)
                {
                    var form = $(this);

                    // Submit form input
                    form.submit();
                }
            }).validate({
                        errorPlacement: function (error, element)
                        {
                            element.before(error);
                        },
                        rules: {
                          //  confirm: {
                          //      equalTo: "#password"
                          //  }
                        }
                    });


	var delParent;
	var defaults = {
		fileType         : ["jpg","png","bmp","jpeg"],   // 上传文件的类型
		fileSize         : 1024 * 1024 * 10                  // 上传文件的大小 10M
	};
		/*点击图片的文本框*/
	$(".file").change(function(){	 
		var idFile = $(this).attr("id");
		var file = document.getElementById(idFile);
		var imgContainer = $(this).parents(".z_photo"); //存放图片的父亲元素
		var fileList = file.files; //获取的图片文件
		var input = $(this).parent();//文本框的父亲元素
		var imgArr = [];
		//遍历得到的图片文件
		var numUp = imgContainer.find(".up-section").length;
		var totalNum = numUp + fileList.length;  //总的数量
		if(fileList.length > 5 || totalNum > 5 ){
			alert("上传图片数目不可以超过5个，请重新选择");  //一次选择上传超过5个 或者是已经上传和这次上传的到的总数也不可以超过5个
		}
		else if(numUp < 5){
			
			fileList = validateUp(fileList);
			for(var i = 0;i<fileList.length;i++){
				//alert(fileList[i].name);
				myArray.push(fileList[i]);
			 var imgUrl = window.URL.createObjectURL(fileList[i]);
			     imgArr.push(imgUrl);
			 var $section = $("<section class='up-section fl loading'>");
			     imgContainer.prepend($section);
			 var $span = $("<span class='up-span'>");
			     $span.appendTo($section);
			
		     var $img0 = $("<img class='close-upimg'>").on("click",function(event){
				    event.preventDefault();
					event.stopPropagation();
					$(".works-mask").show();
					delParent = $(this).parent();
				});   
				$img0.attr("src","img/a7.png").appendTo($section);
		     var $img = $("<img name='uimg' class='up-img up-opcity'>");
		         $img.attr("src",imgArr[i]);
		         $img.appendTo($section);
		     var $p = $("<p class='img-name-p'>");
		         $p.html(fileList[i].name).appendTo($section);
		     var $input = $("<input id='taglocations'  name='taglocations' type='hidden'>");
		     	$input.attr("value",imgArr[i]);
		         $input.appendTo($section);
		     var $input2 = $("<input id='tags' name='tags' value='' type='hidden'/>");
		         $input2.appendTo($section);
		      
		   }
		}
		setTimeout(function(){
             $(".up-section").removeClass("loading");
		 	 $(".up-img").removeClass("up-opcity");
		 },450);
		 numUp = imgContainer.find(".up-section").length;
		if(numUp >= 5){
			$(this).parent().hide();
		}
	});
	
	
   
    $(".z_photo").delegate(".close-upimg","click",function(){
     	  $(".works-mask").show();
     	  delParent = $(this).parent();
	});
		
	$(".wsdel-ok").click(function(){
		$(".works-mask").hide();
		var numUp = delParent.siblings().length;
		if(numUp < 6){
			delParent.parent().find(".z_file").show();
		}
		 delParent.remove();
	});
	
	$(".wsdel-no").click(function(){
		$(".works-mask").hide();
	});
		
		function validateUp(files){
			var arrFiles = [];//替换的文件数组
			for(var i = 0, file; file = files[i]; i++){
				//获取文件上传的后缀名
				var newStr = file.name.split("").reverse().join("");
				if(newStr.split(".")[0] != null){
						var type = newStr.split(".")[0].split("").reverse().join("");
						console.log(type+"===type===");
						if(jQuery.inArray(type, defaults.fileType) > -1){
							// 类型符合，可以上传
							if (file.size >= defaults.fileSize) {
								alert(file.size);
								alert('您这个"'+ file.name +'"文件大小过大');	
							} else {
								// 在这里需要判断当前所有文件中
								arrFiles.push(file);	
							}
						}else{
							alert('您这个"'+ file.name +'"上传类型不符合');	
						}
					}else{
						alert('您这个"'+ file.name +'"没有类型, 无法识别');	
					}
			}
			return arrFiles;
		}


       });
    </script>

</body>

</html>
