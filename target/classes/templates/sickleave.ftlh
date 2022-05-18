<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <div class="loginn">
        <p>Добавление больничного листа</p>

        <form action="/sickleave" method="post">
            <div class="vvod">
                <label>
                    Адрес больницы:
                    <select name="policlinic_sick">
                        <option selected value=0 >Выберите адрес</option>
                        <#list places>
                            <#items as place>
                                <div class="vvod"><option value="${place.idplace}">${place.address}</option></div>
                            </#items>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="vvod"><label>Дата выдачи: <input type="date" name="date_sick" /></label></div>
            <div class="vvod"><label>ОГРН: <input type="text" name="ogrn" /></label></div>
            <div class="vvod">
                <label>
                    Пациент:
                    <input type="text" name="patient_sick" list="users" placeholder="Выберите пользователя"/>
                    <datalist id="users">
                        <#list users>
                            <#items as patient_sick>
                                <div class="vvod"><option value="${patient_sick.id}">${patient_sick.policy_number}</option></div>
                            </#items>
                        </#list>
                    </datalist>
                </label>
            </div>
            <div class="vvod">
                <label>
                    Причина нетрудоспособности:
                    <select name="code_sick">
                        <option selected value=0 >Выберите код</option>
                        <#list codes>
                            <#items as code>
                                <div class="vvod"><option value="${code.id_code}">${code.descript_code}</option></div>
                            </#items>
                        </#list>
                    </select>
                </label>
                </div>
                <div class="vvod"><label>Место работы пациента: <input type="text" name="place_work" /></label></div>

                <div class="vvod"><label>С какого числа: <input type="date" name="start_sick" /></label></div>
                <div class="vvod"><label>По какое число: <input type="date" name="end_sick" /></label></div>

            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Сохранить</button>
        </form>
        <a href="#" onclick="history.back();return false;">Вернуться назад</a>
    </div>

</@c.page>