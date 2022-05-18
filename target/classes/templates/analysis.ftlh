<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <div class="loginn">
        <#if isDoctor>
        <p>Добавление анализа</p>

        <form action="/analysis" method="post">
            <div class="vvod"><label>Название анализа: <input type="text" name="name_analysis" /></label></div>
            <div class="vvod"><label>Дата сдачи анализа: <input type="date" name="date_analysis" /></label></div>
            <div class="vvod"><label>Результат анализа: <input type="text" name="result" /></label></div>
            <div class="vvod">
                <label>
                    Пользователь:
                    <select name="user">
                        <option selected value=0 >Выберите пользователя</option>
                        <#list users>
                            <#items as user>
                                <div class="vvod"><option value="${user.id}">${user.username}</option></div>
                            </#items>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="vvod">
                <label>
                    Адрес больницы:
                    <select name="policlinic">
                        <option selected value=0 >Выберите адрес</option>
                        <#list places>
                            <#items as place>
                                <div class="vvod"><option value="${place.idplace}">${place.address}</option></div>
                            </#items>
                        </#list>
                    </select>
                </label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Добавить</button>
        </form>
        </#if>

    </div>


</@c.page>