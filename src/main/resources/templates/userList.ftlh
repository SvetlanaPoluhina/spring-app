<#import "parts/common.ftlh" as c>

<@c.page>
    <#include "parts/menu_admin.ftlh">

    <div class="loginn">
        <p>Спсиок пользователей</p>

        <table>
            <thead>
            <tr>
                <th>Логин</th>
                <th>Статус</th>
                <th>Изменить</th>
            </tr>
            </thead>
            <tbody>
            <#list users as user>
                <tr>
                    <td>${user.username}</td>
                    <td><#list user.roles as role>${role}<#sep>, </#list></td>
                    <td><a href="/user/${user.id}">изменить</a></td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>