<#include "parts/security.ftlh">
<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>
<@c.page>
    <@l.logout />
    <div class="main">
        <p>Электронная Медицинская Карта</p>
        <form action="/userProfile">
            <button>Мой профиль</button>
        </form>
        <#if isAdmin>
            <form action="/user">
                <button>Список пользователей</button>
            </form>
            <form action="/analysisList">
                <button>Список анализов</button>
            </form>
            <form action="/vaccineList">
                <button>Список прививок</button>
            </form>
        <#else>
            <#if isDoctor>
                <form action="/appointmentDiary">
                    <button>Дневник приемов</button>
                </form>
                <form action="/analysis">
                    <button>Добавить анализ</button>
                </form>
                <form action="/vaccines">
                    <button>Добавить прививку</button>
                </form>
                <#else>
                    <#if isRegist>
                        <form action="/appointmentList">
                            <button>Подтверждение записей</button>
                        </form>
                        <form action="/adminAppointment1">
                            <button>Записать на прием</button>
                        </form>
                        <#else>
                            <form action="/userAppList/${currentUserId}">
                                <button>Мои записи на прием</button>
                            </form>
                            <form action="/userAppointment1">
                                <button>Запись на прием</button>
                            </form>
                            <form action="/userAnalysis/${currentUserId}">
                                <button>Мои анализы</button>
                            </form>
                            <form action="/userSickleave/${currentUserId}">
                                <button>Мои больничные листы</button>
                            </form>
                            <form action="/userReport/${currentUserId}">
                                <button>Мои заключения</button>
                            </form>
                            <form action="/userVaccine/${currentUserId}">
                                <button>Мои прививки</button>
                            </form>
                    </#if>
            </#if>
        </#if>
        <form action="">
            <button>Справочники</button>
        </form>
        <form action="/place">
            <button>Адреса больниц</button>
        </form>
    </div>
</@c.page>