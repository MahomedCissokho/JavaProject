<?php
    $password = $_GET['password'];
    $user_password = "devops";

    
    if($password == $user_password){
        echo "true\n";
        echo "Bienvenue Cher utilisateur, votre mot de passe est ".$password ;
    }else{
        echo "false\n";
        echo "Aucun utilsateur avec ce mot de passe n'est enregistre dans le systeme !";
    }
?>