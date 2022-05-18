<#include "security.ftlh">
<#macro login path isRegisterForm>
    <form action="${path}" method="post" xmlns="http://www.w3.org/1999/html">
        <div class="login">
            <div class="vvod"><label>Логин:  <input type="text" name="username"/></label></div>
            <div class="vvod"><label>Пароль: <input type="password" name="password"/> </label></div>
            <#if isRegisterForm>
                <div class="vvod"><label> Фамилия: <input type="text" name="lastname"/> </label></div>
                <div class="vvod"><label> Имя: <input type="text" name="firstname"/> </label></div>
                <div class="vvod"><label> Отчество: <input type="text" name="patronymic"/> </label></div>
                <div class="vvod"><label> Дата рождения: <input type="date" name="birthday"/> </label></div>
                <div class="vvod"><label> № Полиса ОМС: <input type="text" name="policy_number"/> </label></div>
                <div class="vvod"><label> Телефон: <input type="text" name="phone"/> </label></div>
                <div class="vvod"><label> Эл. почта: <input type="text" name="email"/> </label></div>
                <div class="vvod">
                    <label>
                        Группа крови:
                        <select name="group_blood">
                            <option selected value=0 >Выберите группу крови</option>
                            <#list groups>
                                <#items as group>
                                    <div class="vvod"><option value="${group.id_group_blood}">${group.bloodtype}</option></div>
                                </#items>
                            </#list>
                        </select>
                    </label>
                </div>
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit"/><#if isRegisterForm>Сохранить<#else>Войти</#if></button>
            <#if !isRegisterForm><div><a href="/registration">Зарегистрироваться</a></div></#if>
        </div>
    </form>
</#macro>

<#macro logout>
    <div id="form_menu" align="right">
        <form action="/logout" method="post" >
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit"/>Выйти</button>
            <p id="name">${name}</p>
        </form>
    </div>
</#macro>