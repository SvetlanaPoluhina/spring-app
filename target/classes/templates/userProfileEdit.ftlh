<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="login">

        <form method="post">
            <div>
                <p>Изменение личных данных пользователя ${username}:</p>
                <div class="vvod"><label>Пароль: <input type="password" name="password"/></label></div>
                <div class="vvod"><label>Фамилия: <input type="lastname" name="lastname" value="${lastname!''}" /></label></div>
                <div class="vvod"><label>Имя: <input type="firstname" name="firstname" value="${firstname!''}" /></label></div>
                <div class="vvod"><label>Отчество: <input type="patronymic" name="patronymic" value="${patronymic!''}" /></label></div>
                <div class="vvod"><label>Дата Рождения:<input type="birthday" name="birthday" value="${birthday!''}" /></label></div>
                <div class="vvod"><label>Номер полиса ОМС: <input type="policy_number" name="policy_number" value="${policy_number!''}" /></label></div>
                <div class="vvod"><label>Телефон: <input type="phone" name="phone" value="${phone!''}" /></label></div>
                <div class="vvod"><label>Эл. почта: <input type="email" name="email" value="${email!''}" /></label></div>
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
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Сохранить</button>
        </form>
    </div>
</@c.page>