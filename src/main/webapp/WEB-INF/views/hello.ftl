<html>
<body>
<h1>Hello</h1>

<h2>h2</h2>
<#if var??>
    ${var}
</#if>
<#if headers??>
    <#list headers?keys as prop>
    ${prop} = ${headers[prop]}
    <br>
    </#list>
</#if>
</body>
</html>