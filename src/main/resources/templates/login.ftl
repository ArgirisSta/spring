<!doctype html>
<html class="no-js" lang="en" dir="ltr" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foundation for Sites</title>
    <link rel="stylesheet" href="css/foundation.css">
    <link rel="stylesheet" href="css/app.css">
    <link rel="stylesheet" href="css/all.css">
    <link rel="stylesheet" href="css/my.css">
</head>
<body>
<#import "/spring.ftl" as spring />
<div class="grid-container">
    <ul class="menu">
        <li><a href="/login"><i class="fas fa-sign-in-alt"></i> <span>Sign in</span></a></li>
        <li><a href="/register"><i class="fas fa-pencil-alt"></i> <span>Register</span></a></li>
    </ul>

    <div class="grid-x grid-padding-x">
        <div class="large-12 cell">
            <div class="callout">
                <div class="row">
                    <div class="callout  text-center">
                        <img src="images/login.png" width="150">
                        <form action="/login" method="POST">
                            <h1>Log in</h1>

                                <div class="float-left">
                                    <i class="fas fa-envelope"></i> <span>E-mail</span>
                                </div>

                                <input type="email" name="username" placeholder="E-mail" required>

                                <div class="float-left">
                                    <i class="fas fa-key"></i> <span>Password</span>
                                </div>

                                <input type="password" name="password" placeholder="Password" required>


                            </div>
                            <input type="submit" value="Log in" class="button expanded large">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/vendor/jquery.js"></script>
<script src="js/vendor/what-input.js"></script>
<script src="js/vendor/foundation.js"></script>
<script src="js/app.js"></script>
</body>
</html>
