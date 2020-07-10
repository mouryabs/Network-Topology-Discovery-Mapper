<html>
<head>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html"%>
      
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
<link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>

<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    
<script type="text/javascript" src="jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
</head>
<body>
  <nav class="light-blue lighten-1 " role="navigation" id="nav">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">ISRO</a>
      
      <ul class="right hide-on-med-and-down">
        <li><a href="contact.jsp">Contact</a></li>
      </ul>
        
      <ul class="right hide-on-med-and-down">
        <li><a href="services.jsp">Services</a></li>
      </ul>
        
      <ul class="right hide-on-med-and-down">
        <li><a href="about.jsp">About Us</a></li>
      </ul>
        
      <ul class="right hide-on-med-and-down">
        <li><a href="index.jsp">Home</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  <div class="carousel carousel-slider center" data-indicators="true">
    <div class="carousel-fixed-item center">    
      <a class="btn waves-effect white grey-text darken-text-3" href="user2.jsp">START</a>
    </div>
    <div class="carousel-item light-blue white-text row" href="#one!">
      <div class="col l6">
      <img src="images/manage.jpg"/>
      </div>
      <div class="col l6">
    <CENTER>
        <p><h1>Easy to manage</h1></p> </CENTER>
        <p class="white-text"> With a wide range of network utilities, it is easy to get great insights into your network. Check switch statuses, printer details, VLAN information and more!</p>
      </div>
    </div>
    <div class="carousel-item amber white-text row" href="#two!">
      <div class="col l6">
          <p class="white-text"><h1>Visualise the network</h1></p> 
          <p> A topology map lets you see where each of your network components are and how they are arranged!</p>
      </div>
      <div class="col l6">
      <img src="images/network.jpg"/>
      </div>
    </div>
    <div class="carousel-item deep-orange lighten-1 white-text row" href="#three!">
      <div class="col l6">
      <img src="images/switch.jpg"/>
      </div>
      <div class="col l6">
      <p class="white-text"><h1>Deatiled switch information</h1></p> 
      <p> Get a look at port statuses, in packets, out packets and more!</p>
      </div>
    </div>
    <div class="carousel-item light-green lighten-1 white-text row" href="#four!">
      <div class="col l6">
          <p class="white-text"><h1>Printer</h1></p> 
          <p>See where your printers are and which devices they are connected to!</p>
      </div>
      <div class="col l6">
      <img src="images/printer.jpg"/>
    </div>
  </div>
</div>
  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text"><i class="material-icons">flash_on</i></h2>
            <h5 class="center">Speeds up network management</h5>

            <p class="light">We did most of the heavy lifting for you to provide a default stylings that incorporate our custom components. Additionally, we refined animations and transitions to provide a smoother experience for developers.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text"><i class="material-icons">group</i></h2>
            <h5 class="center">User Experience Focused</h5>

            <p class="light">By utilizing elements and principles of Material Design, we were able to create a framework that incorporates components and animations that provide more feedback to users. Additionally, a single underlying responsive system across all platforms allow for a more unified user experience.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-blue-text"><i class="material-icons">settings</i></h2>
            <h5 class="center">Easy to work with</h5>

            <p class="light">We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize.</p>
          </div>
        </div>
      </div>

    </div>
    <br><br>

    <div class="section">

    </div>
  </div>

  <footer class="page-footer orange">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Company Bio</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Settings</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Connect</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
      </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>
   <script type="text/javascript">
    $('.carousel.carousel-slider').carousel({fullWidth: true});
    </script>
  </body>
</html>
