<!doctype html>
<html class="no-js" lang="en" dir="ltr" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Foundation for Sites</title>
    <script src='https://www.google.com/recaptcha/api.js'></script>
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
                        <img src="images/register.png" width="150">
                        <form action="/register" method="POST">
                            <h1>Register</h1>
                            <div class="text-left">
                                <div class="float-left">
                                    <i class="fas fa-signature"></i> <span>First Name</span>
                                </div>

                                <@spring.bind "registrationForm.firstName"/>
                                <input type="text" name="firstName" placeholder="First Name" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                <div class="float-left">
                                    <i class="fas fa-signature"></i> <span>Last Name</span>
                                </div>

                                <@spring.bind "registrationForm.lastName"/>
                                <input type="text" name="lastName" placeholder="Last Name" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                <div class="float-left">
                                    <i class="fas fa-envelope"></i> <span>E-mail</span>
                                </div>

                                <input type="email" name="email" placeholder="E-mail" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                <#if emailDuplicate??>
                                    <span class="float-center">${emailDuplicate} already exists!</span>
                                </#if>

                                <div class="float-left">
                                    <i class="fas fa-building"></i> <span>Company</span>
                                </div>

                                <@spring.bind "registrationForm.companyName"/>
                                <input type="text" name="company" placeholder="Company">
                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                    <div class="float-left">
                                        <i class="fas fa-phone"></i> <span>Phone</span>
                                    </div>

                                <@spring.bind "registrationForm.phoneNumber"/>
                                    <input type="tel" name="phoneNumber" placeholder="Phone">

                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>



                                <div class="float-left">
                                    <i class="fas fa-key"></i> <span>Password</span>
                                </div>

                                <@spring.bind "registrationForm.password"/>
                                <input type="password" name="password" placeholder="Password" required>

                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                <div class="float-left">
                                    <i class="fas fa-key"></i> <span>Repeat Password</span>
                                </div>

                                <@spring.bind "registrationForm.confirmPassword"/>
                                <input type="password" name="repeatPassword" placeholder="Repeat Password" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>
                            <input type="submit" value="Register" class="button expanded large">
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
