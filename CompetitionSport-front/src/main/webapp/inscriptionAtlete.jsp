<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- ===== Iconscout CSS ===== -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    
    <style>
        /* ===== Google Font Import - Poformsins ===== */
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap');

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}

body{
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
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
    margin: 0 20px;
}

.container .form{
    width: 100%;
    padding: 30px;
    background-color: #fff;
    transition: margin-left 0.18s ease;
}


.container.active .signup{
    opacity: 1;
    transition: opacity 0.2s ease;
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

    </style>

    <script src="https://code.iconify.design/2/2.1.2/iconify.min.js"></script>

    <title>Inscription</title>
         
</head>
<body>
    
    <div class="container">
        <div class="forms">

            <div class="form signup">
                <span class="title">Inscription</span>
                <form action="client" method="post">
                    <input type="hidden" name="tache" value="save">
                    <input type="hidden" name="typeCompte" value="athlete">

                    <div class="input-field">
                        <input type="text" name="nom" placeholder="Nom" required>
                        <i class="uil uil-user"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="prenom" placeholder="Prenom" required>
                        <i class="uil uil-user"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="mail" placeholder="Mail" required>
                        <i class="uil uil-envelope icon"></i>
                    </div>
                    <div class="input-field">
                        <input type="password" class="password" placeholder="Password" required>
                        <i class="uil uil-lock icon"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="numero" placeholder="Numéro d'adresse" required>
                        <i class="uil uil-home"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="voie" placeholder="Voie" required>
                        <i class="uil uil-home"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="ville" placeholder="Ville" required>
                        <i class="uil uil-location-point"></i>
                    </div>
                    <div class="input-field">
                        <input type="text" name="cp" placeholder="Code postal" required>
                        <i class="uil uil-location-point"></i>
                    </div>
                    <div class="input-field">
                        <input type="date" name="dateNaissance" required style="color: gray;">
                        <i class="uil uil-calendar-alt"></i>
                    </div>

                    <div class="input-field button">
                        <input type="submit" value="S'INSCRIRE">
                    </div>
                </form>

                <div class="login-signup">
                    <span class="text">Déjà inscrit?
                        <a href="connexion.jsp" class="text login-link">Connexion</a>
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
