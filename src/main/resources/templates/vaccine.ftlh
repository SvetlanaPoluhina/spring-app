<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu_admin.ftlh">
    <div class="loginn">
        <p>Добавление прививки</p>
        <form action="/vaccines" method="post">
            <div class="vvod"><label>Название прививки: <input type="text" name="name_vaccine" /></label></div>
            <div class="vvod"><label>Название препарата: <input type="text" name="name_preparate" /></label></div>
            <div class="vvod"><label>Дата: <input type="date" name="date" /></label></div>
            <div class="vvod"><label>Доза: <input type="text" name="dose_vaccine" /></label></div>
            <div class="vvod"><label>Страна изготовитель: <input type="text" name="country_vaccine" /></label></div>
            <div class="vvod"><label>Результат (для туберкулинодиагностики): <input type="text" name="result_tuberdiagnoz" /></label></div>
            <div class="vvod">
                <label>
                    Пользователь:
                    <select name="patient_vac">
                        <option selected value=0 >Выберите пользователя</option>
                        <#list users>
                            <#items as patient_vac>
                                <div class="vvod"><option value="${patient_vac.id}">${patient_vac.username}</option></div>
                            </#items>
                        </#list>
                    </select>
                </label>
            </div>
            <div class="vvod">
                <label>
                    Адрес больницы:
                    <select name="poliklinik">
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
    </div>

</@c.page>