<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <#include "parts/menu.ftlh">
    <div class="loginn">
        <p>Запись на прием</p>

        <form action="/userAppointment3/${doctori}/${date_app_str}" method="post">
            <input type="hidden" value="${doctori}" name="doctor"/>
            <input type="hidden" value="${date_app_str}" name="date_app" />
            <input type="hidden" value="2" name="status_appointment" />
            <div class="vvod">
                <label>
                    Выберите время приема:
                    <!--input type="time" name="start_app" /-->
                    <select type="time" name="start_app">
                        <option selected value=0 >Выберите время</option>
                        <#list schedulesort>
                            <#items as time>
                                <div class="vvod"><option value="${time}">${time}</option></div>
                            </#items>
                            <#else>
                                <div class="vvod"><option value="0">Нет доступного времени. Пожалуйста, выберите другой день.</option></div>
                        </#list>
                    </select>
                </label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <button type="submit">Записаться</button>
        </form>

        <a href="#" onclick="history.back();return false;">Вернуться назад</a>
    </div>

</@c.page>