<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as r>

<@c.page>
    <div><p>Регистрация пользователя</p></div>
    ${message!" "}
    <@r.login "/registration" true/>


</@c.page>