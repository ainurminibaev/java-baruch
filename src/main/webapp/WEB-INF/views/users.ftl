<html>
<body>
<ul>
<#list users as user>
    <li>
    ${user.login}&nbsp;${user.city}
    </li>
</#list>
</ul>
<br>

<form method="post" action="/guests">
    <input type="text" name="login"/>
    <input name="city"/>
    <button type="submit">Add user</button>
</form>
</body>
</html>