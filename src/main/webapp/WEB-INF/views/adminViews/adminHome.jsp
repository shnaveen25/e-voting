<!DOCTYPE html>
<html lang="">
<head>
<title>Admin home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="static/css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="static/css/font-awesome.min.css" rel="stylesheet">
<link href="static/css/framework.css" rel="stylesheet">
<style>
.container{
  height: 450px;
  width: auto;
}
</style>
</head>
<body id="top">
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row0">
  <div id="topbar" class="hoc clear"> 
<div class="fl_right">
      <ul>
        <li><a href="#"><img src="static/images/demo/logout.jpg"></a></li>
        <li><a href="">Log Out</a></li>
      </ul>
    </div>
</div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<div class="wrapper row1">
  <header id="header" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="adminhome.html">e-voting</a></h1>
      <!--<p>Quisque congue diam</p>-->
    </div>
    <!-- ################################################################################################ -->
  </header>
  <nav id="mainav" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <ul class="clear">
      <li class="active"><a href="adminhome.html">Home</a></li>
      <li><a class="drop" href="#">Elections</a>
        <ul>
          <li><a href="presentelec.html">Present</a></li>
          <li><a href="pastelec.html">Past</a></li>
          <li><a href="futureelec.html">Future</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">Party</a>
        <ul>
          <li><a href="/addParty">Add Party</a></li>
          <li><a href="/DeletPArty">Delete Party</a></li>
      </ul>
    </li>
      <li><a href="file:///C:/Users/AJIT/Desktop/evoting/MemberDesc1.html">Member Description</a></li>
      <li><a href="file:///C:/Users/AJIT/Desktop/evoting/party.html">Party Description</a></li>
      <li><a class="drop" href="file:///C:/Users/AJIT/Desktop/evoting/viewparticipants.html">Participants</a>
        <ul>
          <li><a href="/addParticipantSelectParty">Add Participants</a></li>
          <li><a href="file:///C:/Users/AJIT/Desktop/evoting/viewparticipants.html">View Participants</a></li>
      </ul>
    </li>
    </ul>
    <!-- ################################################################################################ -->
  </nav>
</div>

<div class="container" style="background-image:url('static/images/demo/backgrounds/head.jpg');">
        <center>
        	<font color="Red"> ${message}</font>
          <img src="static/images/demo/backgrounds/eci.jpeg" style="width:1200px;height:450px;">
        </center>
</div>

<div class="wrapper row4 bgded overlay" style="background-image:url('static/images/demo/backgrounds/Online-Voting.jpg');">
  <footer id="footer" class="hoc clear"> 
    <!-- ################################################################################################ -->
    <div class="one_third first">
      <h6 class="heading">Election Commission of India</h6>
      <ul class="nospace btmspace-30 linklist contact">
        <li><i class="fa fa-map-marker"></i>
          <address>
          Nirvachan Sadan, Ashoka Road
          New Delhi
          New Delhi District
          Delhi
          India - 110001
          </address>
        </li>
        <li><i class="fa fa-phone"></i> 011-23717391</li>
        <li><i class="fa fa-fax"></i> 011-23713412</li>
        <li><i class="fa fa-envelope-o"></i> complaints@eci.gov.in</li>
      </ul>
    </div>
    
    <div class="one_third" align="right">
      <h6 class="heading">Tempor orci vestibulum</h6>
      <img class="borderedbox inspace-10 btmspace-15" src="static/images/demo/backgrounds/emblem.jpg" align="right">
        <figcaption>
          <h6 class="nospace font-x1"><a href="#">Write something later</a></h6>
          <time class="font-xs block btmspace-10" datetime="2045-04-06">Friday, 6<sup>th</sup> April 2045</time>
        </figcaption>
      </figure>
    </div>
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!--<div class="wrapper row5">
  <div id="copyright" class="hoc clear"> 
     ################################################################################################ 
    <p class="fl_left">Copyright &copy; 2016 - All Rights Reserved - <a href="#">Domain Name</a></p>
    <p class="fl_right">Template by <a target="_blank" href="http://www.os-templates.com/" title="Free Website Templates">OS Templates</a></p>
     ################################################################################################ 
  </div>-->
</div>
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<!-- ################################################################################################ -->
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a>
<!-- JAVASCRIPTS -->
<script src="static/js/jquery.min.js"></script>
<script src="static/js/jquery.backtotop.js"></script>
<script src="static/js/jquery.mobilemenu.js"></script>
</body>
</html>