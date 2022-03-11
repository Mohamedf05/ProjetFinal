<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>

    <!-- ===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>
 	<link rel="stylesheet" href="style.css">
    <link rel="icon" href="img/logo3.jpg">
    
    <link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Permanent+Marker&display=swap" rel="stylesheet">
	
    
    <style>
        /* ===== Google Font Import - Poformsins ===== */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap');


*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body
{
    background-image: url("img/colisee.jpg");
    background-size: cover;
    background-attachment: fixed;
}

.container{
    position: relative;
    max-width: 350px;
    width: 100%;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
    overflow: hidden;
    margin-top: 5%;
    margin-left: auto;
}

.container .forms{
    display: flex;
    align-items: center;
    height: 300px;
    width: 100%;
    transition: height 0.2s ease;
}


.container .form{
    width: 50%;
    padding: 30px;
    background-color: #fff;
    transition: margin-left 0.18s ease;
}

.container .form{
    width: 100%;
    padding: 30px;
    background-color: #fff;
    transition: margin-left 0.18s ease;
}

.container.active .login{
    margin-left: -50%;
    opacity: 0;
    transition: margin-left 0.18s ease, opacity 0.15s ease;
}


.container.active .forms{
    height: 600px;
}

.container .form .title{
    position: relative;
    font-size: 17px;
    font-weight: 600;
}

.form .title::before{
    content: '';
    position: absolute;
    left: 0;
    bottom: 0;
    height: 1px;
    width: 30px;
    background-color: #4070f4;
    border-radius: 25px;
}

.form .input-field{
    position: relative;
    height: 15px;
    width: 70%;
    margin-top: 30px;
}

.input-field input{
    position: absolute;
    height: 100%;
    /*width: 100%;*/
    padding: 0 35px;
    border: none;
    outline: none;
    font-size: 12px;
    border-bottom: 2px solid #ccc;
    border-top: 2px solid transparent;
    transition: all 0.2s ease;
}

.input-field input:is(:focus, :valid){
    border-bottom-color: #4070f4;
}

.input-field i{
    position: absolute;
    top: 50%;
    transform: translateY(-50%);
    color: #999;
    font-size: 14px;
    transition: all 0.2s ease;
}

.input-field input:is(:focus, :valid) ~ i{
    color: #4070f4;
}

.input-field i.icon{
    left: 0;
}
.input-field i.showHidePw{
    right: 0;
    cursor: pointer;
    padding: 10px;
}

.form .text{
    color: #333;
    font-size: 14px;
}

.form a.text{
    color: #4070f4;
    text-decoration: none;
}
.form a:hover{
    text-decoration: underline;
}

.form .button{
    margin-top: 35px;
    height: 25px;
}

.form .button input{
    border: none;
    color: #fff;
    font-size: 13px;
    font-weight: 500;
    letter-spacing: 1px;
    border-radius: 6px;
    background-color: #4070f4;
    cursor: pointer;
    transition: all 0.3s ease;
}

.button input:hover{
    background-color: #265df2;
}

.form .login-signup{
    margin-top: 30px;
    text-align: center;
}

header{
  background-color : rgb(225,203,147);
}

#imglogo{
	border-radius: 50%;
}

h1{
font-family: 'Permanent Marker', cursive;
text-align: center;
}

    </style>


    <c:if test="${connected.getClass().getSimpleName()=='Organisateur'}">
	<c:redirect url = "organisateur.jsp"/>
    </c:if>
    <c:if test="${connected.getClass().getSimpleName()=='Athlete'}">
	<c:redirect url = "athlete.jsp"/>
    </c:if>
    <c:if test="${connected.getClass().getSimpleName()=='Spectateur'}">
	<c:redirect url = "spectateur.jsp"/>
    </c:if>
    <c:if test="${connected.getClass().getSimpleName()=='Journaliste'}">
	<c:redirect url = "journaliste.jsp"/>
    </c:if>

    <title>Connexion</title>
         
</head>
<body>
    
    <header>
        <div id="banniere">
        
          <a href="index.jsp"><div id="logo"><img id="imglogo" src="img/logo3.jpg" alt="logo"></div></a>
        <h1> SPORT EVENTS</h1>
            <div class="menuBanniere">
              <table>
                <tr>
                  <td></td>
                  <td></td>
                </tr>
              </table>
            </div>
        </div>
    </header>


    <div class="container">
        <div class="forms">
            <div class="form login">
                <span class="title">Connexion</span>

                <form action="home" method="post">
                    <div class="input-field">
                        <input type="text" name="mail" placeholder="Mail" required>
                        <i class="uil uil-envelope icon"></i>
                    </div>
                    <div class="input-field">
                        <input type="password" name="password" class="password" placeholder="Password" required>
                        <i class="uil uil-lock icon"></i>
                        <i class="uil uil-eye-slash showHidePw"></i>
                    </div>

                    <div class="input-field button">
                        <input type="submit" value="CONTINUER">
                    </div>
                </form>

                <div class="login-signup">
                    <span class="text">Vous n'avez pas encore de compte ?
                        <a href="inscription.jsp" class="text signup-link">Inscrivez-vous</a>
                    </span>
                </div>
            </div>
        </div>
    </div>

    <script>
    const container = document.querySelector(".container"),
    pwShowHide = document.querySelectorAll(".showHidePw"),
    pwFields = document.querySelectorAll(".password");

    //   js code to show/hide password and change icon
    pwShowHide.forEach(eyeIcon =>{
        eyeIcon.addEventListener("click", ()=>{
            pwFields.forEach(pwField =>{
                if(pwField.type ==="password"){
                    pwField.type = "text";

                    pwShowHide.forEach(icon =>{
                        icon.classList.replace("uil-eye-slash", "uil-eye");
                    })
                }else{
                    pwField.type = "password";

                    pwShowHide.forEach(icon =>{
                        icon.classList.replace("uil-eye", "uil-eye-slash");
                    })
                }
            }) 
        })
    })

</script>
</body>
</html>
