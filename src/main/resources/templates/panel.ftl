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
        <li><a href="/logout"><i class="fas fa-sign-out-alt"></i> <span>Sign out</span></a></li>
    </ul>

    <div class="grid-x grid-padding-x">
        <div class="large-12 cell">
            <div class="callout">
                <div class="row">
                    <div class="callout  text-center">
                        <img src="images/cp.png" width="150">
                        <form action="/user/update" method="POST">
                            <h1>Welcome ${loggedUser.getFirstName()}</h1>
                            <div class="text-left">
                                <div class="float-left">
                                    <i class="fas fa-signature"></i> <span>First Name</span>
                                </div>

                                <@spring.bind "updateForm.firstName"/>
                                <input type="text" name="firstName" value="${loggedUser.getFirstName()}" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                <div class="float-left">
                                    <i class="fas fa-signature"></i> <span>Last Name</span>
                                </div>

                                <@spring.bind "updateForm.lastName"/>
                                <input type="text" name="lastName" value="${loggedUser.getLastName()}" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                <div class="float-left">
                                    <i class="fas fa-envelope"></i> <span>E-mail</span>
                                </div>

                                <@spring.bind "updateForm.email"/>
                                <input type="email" name="email" value="${loggedUser.getEmail()}" required>
                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                <#if emailDuplicate??>
                                    <span class="float-center">${emailDuplicate} already exists!</span>
                                </#if>

                                <div class="float-left">
                                    <i class="fas fa-building"></i> <span>Company</span>
                                </div>

                                <@spring.bind "updateForm.companyName"/>
                                <#if loggedUser.getCompanyName()??>
                                    <input type="text" name="company" value="${loggedUser.getCompanyName()}">
                                <#else>
                                    <input type="text" name="company" placeholder="Company">
                                </#if>

                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>

                                    <div class="float-left">
                                        <i class="fas fa-phone"></i> <span>Phone</span>
                                    </div>

                                <@spring.bind "updateForm.phoneNumber"/>
                                <#if loggedUser.getPhoneNumber()??>
                                    <input type="text" name="phoneNumber" value="${loggedUser.getPhoneNumber()}">
                                <#else>
                                    <input type="text" name="phoneNumber" placeholder="Phone Number">
                                </#if>

                                <div class="float-left">
                                    <i class="fas fa-key"></i> <span>Password</span>
                                </div>

                                <@spring.bind "updateForm.password"/>
                                <input type="password" name="password" placeholder="Password" required>

                                <#list spring.status.errorMessages as error>
                                    <span class="float-center">${error}</span>
                                </#list>
                            </div>
                            <input type="submit" value="Update" class="button expanded large">
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
