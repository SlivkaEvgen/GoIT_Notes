<#include "security.ftlh">
<#import "login.ftlh" as l>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Note Storage</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <!--<li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/">Home</a>
                </li>-->
                <#if user??>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/note/list">My Notes</a>
                </li>
                </#if>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/users">User list</a>
                </li>
                </#if>
            </ul>
        </div>
        <div class="navbar-text">${name}</div>
    </div>
    <#if user??>
    <@l.logout />
    </#if>
</nav>