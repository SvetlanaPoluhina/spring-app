<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#if !isAdmin>
        <#include "parts/menu.ftlh">
    </#if>
    <#if isAdmin>
        <#include "parts/menu_admin.ftlh">
    </#if>
    <div class="loginn">
    <#if isAdmin>
        <p>Добавление адреса</p>

        <form action="/place" method="post">
            <div class="vvod"><label><input type="text" name="address" /></label></div>

            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
        </div>
    </#if>

    <div class="loginnn">
        <div><p>Список адресов:</p></div>

        <table>
            <thead>
            <tr>
                <th>Адрес</th>
                <#if isAdmin>
                    <th>Изменить</th>
                </#if>
            </tr>
            </thead>
            <tbody>
            <#list places>
                <#items as place>
                    <tr>
                        <td>${place.address}</td>
                        <#if isAdmin>
                            <td><a href="/placeEdit/${place.idplace}">изменить</a></td>
                        </#if>
                    </tr>
                </#items>
            <#else>
                <p> Список пуст </p>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>