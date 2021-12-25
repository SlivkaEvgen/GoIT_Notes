<#import "parts/common.ftlh" as p>
<#import "parts/modal.ftlh" as m>
<#import "parts/message.ftlh" as a>
<@p.page>
<#if message??>
<@a.error />
</#if>
<div class="">
    <div class="row ">
        <p class="fs-3 ">My notes - ${noteCount} pcs.</p>
        <div>
        <button type="button" class="btn btn-primary mb-3 col-auto" onclick="location.href='/note/create'">Create note</button>
        </div>
    </div>

    <table class="table table-striped table-hover table-hover-cursor table align-middle" style="table-layout: fixed">
        <thead>
        <tr>
            <th class="col-2 " scope="col">Name</th>
            <th class="col-5" scope="col">Message</th>
            <th class="col-1 justify-content-center mx-auto" scope="col">Access type</th>
            <th class="col-1 " scope="col"></th>
        </tr>
        </thead>
        <#list notes as note>
        <tbody>
        <tr class="">
            <td class="text-truncate">${note.name}</td>
            <td class="text-truncate">${note.message}</td>
            <td class="">${note.accessType}</td>
            <td  style="font-size: 1rem; ">
                <i class="bi-card-text mx-1" style="cursor:pointer" onclick="location.href='/note/share/${note.id}'"></i>
                <i class="bi-pencil mx-1" style="cursor:pointer" onclick="location.href='/note/edit/${note.id}'"></i>
                <i class="bi-trash mx-1" style="cursor:pointer" onclick="location.href='/note/delete/${note.id}'"></i>
                <i class="bi-link-45deg mx-1" style="cursor:pointer" data-bs-toggle="modal" data-bs-target="#linkModal"
                   data-bs-whatever="/note/share/${note.id}"></i>
            </td>
        </tr>
        <#else>
<!--       list not exist-->
        </#list>
        </tbody>
    </table>
<@m.modal />
</div>
</@p.page>