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
                                æ³¨å
                            </h2>
                            <p>
                                ç¨æ·æ¯ä»åå¡«åç¸å³ä¿¡æ¯ï¼å®ææ³¨åã
                            </p>
<form id="form"  enctype="multipart/form-data" action="form_wizard.html#" class="wizard-big">
                                <h1>è®¢åä¿¡æ¯</h1>
                                <fieldset>
                                    <h2>è®¢åä¿¡æ¯å¡«å</h2>
                                    <div class="row">
                                        <div class="col-lg-8">
                                            <div class="form-group">
                                                <label>ç¨æ·å *</label>
                                                <input id="userName" name="userName" type="text" class="form-control required">
                                            </div>
											<div class="form-group">
                                                <label>æ·å®è®¢åå· *</label>
                                                <input id="orderId" name="orderId" type="text" class="form-control required">
                                            </div>
											<div class="form-group">
                                                <label>èç³»ææºå· *</label>
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
                                <h1>ç³è¯·èµæ</h1>
                                <fieldset>
                                    <h2>å°ç¨åºç³è¯·ç¸å³èµæ</h2>
                                    <div class="row">

                                        <div class="col-lg-8">
											<div class="form-group">
											<div><label>ä¼ä¸ç±»å *</label></div>
														<div class="radio radio-info radio-inline">
															<input type="radio" id="inlineRadio1" value="1" name="radioInline" checked="">
															<label for="inlineRadio1"> ä¼ä¸ </label>
														</div>
														<div class="radio radio-inline">
															<input type="radio" id="inlineRadio2" value="2" name="radioInline">
															<label for="inlineRadio2"> ä¸ªä½å·¥åæ· </label>
														</div>
													</div>
                                            <div class="form-group">
                                                <label>è¯ä»¶ç§ç *
													<input type='button' value='ä¸ä¼ ' onclick='test()' class="ladda-button ladda-button-demo btn btn-primary"  data-style="zoom-in"></input>
												</label>
												<!--
												<label title="Upload image file" for="inputImage" class="btn btn-primary">
													<input type="file" name="zj" id="zj" accept="image/*" capture="camera" onchange ="upIamge(this,'zj_iamge','zj_view');" class="form-control required">
													
												</label>
												-->
												<div class="z_photo upimg-div clear" >
												<section class="z_file fl">
																		<img src="img/a11.png" class="add-img">
																		<input type="file" capture="camera" name="file" id="file" class="file" value="" accept="image/jpg,image/jpeg,image/png,image/bmp" multiple />
																	 </section>
																	 </div>
												<aside class="mask works-mask">
														<div class="mask-content">
															<p class="del-p ">æ¨ç¡®å®è¦å é¤ä½åå¾çåï¼</p>
															<p class="check-p"><span class="del-com wsdel-ok">ç¡®å®</span><span class="wsdel-no">åæ¶</span></p>
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

                                <h1>é¨åºå±ç¤º</h1>
                                <fieldset>
                                    <div class="row">
                                        <div class="col-lg-8">
                                            <div class="form-group">
                                                <label>éè¿å°ç¨åºåè¡¨å±ç¤ºåç§° *</label>
                                                <input id="userName" name="userName" type="text" class="form-control required">
                                            </div>
											<div class="form-group">
                                                <label>è¥ä¸æ¶é´ *</label>
                                                <input id="orderId" name="orderId" type="text" class="form-control required">
                                            </div>
											<div class="form-group">
                                                <label>é¨åºç§ç *</label>
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

                                <h1>æäº¤æå</h1>
                                <fieldset>
                                    <h2>æ³¨åæåäº</h2>
                                    
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

	function test(){
		alert(333);
		var imgContainer = $(".z_photo"); //å­æ¾å¾ççç¶äº²åç´ 
		//éåå¾å°çå¾çæä»¶
		var numUp = imgContainer.find(".up-img");
		alert(numUp[0].src);
		console.log(numUp[0]);

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
		fileType         : ["jpg","png","bmp","jpeg"],   // ä¸ä¼ æä»¶çç±»å
		fileSize         : 1024 * 1024 * 10                  // ä¸ä¼ æä»¶çå¤§å° 10M
	};
		/*ç¹å»å¾ççææ¬æ¡*/
	$(".file").change(function(){	 
		var idFile = $(this).attr("id");
		var file = document.getElementById(idFile);
		var imgContainer = $(this).parents(".z_photo"); //å­æ¾å¾ççç¶äº²åç´ 
		var fileList = file.files; //è·åçå¾çæä»¶
		var input = $(this).parent();//ææ¬æ¡çç¶äº²åç´ 
		var imgArr = [];
		//éåå¾å°çå¾çæä»¶
		var numUp = imgContainer.find(".up-section").length;
		var totalNum = numUp + fileList.length;  //æ»çæ°é
		if(fileList.length > 5 || totalNum > 5 ){
			alert("ä¸ä¼ å¾çæ°ç®ä¸å¯ä»¥è¶è¿5ä¸ªï¼è¯·éæ°éæ©");  //ä¸æ¬¡éæ©ä¸ä¼ è¶è¿5ä¸ª æèæ¯å·²ç»ä¸ä¼ åè¿æ¬¡ä¸ä¼ çå°çæ»æ°ä¹ä¸å¯ä»¥è¶è¿5ä¸ª
		}
		else if(numUp < 5){
			fileList = validateUp(fileList);
			for(var i = 0;i<fileList.length;i++){
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
		     var $img = $("<img class='up-img up-opcity'>");
		         $img.attr("src",imgArr[i]);
		         $img.appendTo($section);
		     var $p = $("<p class='img-name-p'>");
		         $p.html(fileList[i].name).appendTo($section);
		     var $input = $("<input id='taglocation' name='taglocation' value='' type='hidden'>");
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
			var arrFiles = [];//æ¿æ¢çæä»¶æ°ç»
			for(var i = 0, file; file = files[i]; i++){
				//è·åæä»¶ä¸ä¼ çåç¼å
				var newStr = file.name.split("").reverse().join("");
				if(newStr.split(".")[0] != null){
						var type = newStr.split(".")[0].split("").reverse().join("");
						console.log(type+"===type===");
						if(jQuery.inArray(type, defaults.fileType) > -1){
							// ç±»åç¬¦åï¼å¯ä»¥ä¸ä¼ 
							if (file.size >= defaults.fileSize) {
								alert(file.size);
								alert('æ¨è¿ä¸ª"'+ file.name +'"æä»¶å¤§å°è¿å¤§');	
							} else {
								// å¨è¿ééè¦å¤æ­å½åæææä»¶ä¸­
								arrFiles.push(file);	
							}
						}else{
							alert('æ¨è¿ä¸ª"'+ file.name +'"ä¸ä¼ ç±»åä¸ç¬¦å');	
						}
					}else{
						alert('æ¨è¿ä¸ª"'+ file.name +'"æ²¡æç±»å, æ æ³è¯å«');	
					}
			}
			return arrFiles;
		}


       });
    </script>

</body>

</html>
