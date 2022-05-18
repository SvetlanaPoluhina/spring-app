<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="greeting">
        <h>Войти в систему</h>
    </div>

    <@l.login "/login" false/>

</@c.page>