<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>
    <meta http-equiv="refresh" content="10">
    <title>Web Checkers | ${title}</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<body>
<div class="page">

    <h1>Web Checkers | ${title}</h1>


    <div class="body">

        <form action="/signin" method="POST">
            <#if invalidUsername??>
                ${invalidUsername}
            </#if>

            <br/>
            Username:
            <input name="myUsername" />
            <br/><br/>
            <button type="submit">Sign In</button>
            <br/>
        <form/>


        <!-- Provide a message to the user, if supplied. -->
        <#include "message.ftl" />

        <!-- TODO: future content on the Home:
                to start games,
                spectating active games,
                or replay archived games
        -->

    </div>

</div>
</body>

</html>