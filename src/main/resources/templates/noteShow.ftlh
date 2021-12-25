<#import "parts/common.ftlh" as p>
<#import "parts/message.ftlh" as a>
<@p.page>
<#if note??>
<div class="fs-4 mb-3" style="overflow-y:auto;  max-height:800px">
    <b >Note name: </b>${note.name}
</div>
<div class="card">
    <div class="card-body" style="overflow-y:auto;  max-height:800px">
            ${note.message}
    </div>
</div>
</#if>
<#if message??>
<div class="fs-3">
    <@a.error />
</div>
</#if>
<button type="button" class="btn btn-primary m-3" onclick="location.href='/note/list'">Return to note's list</button>
</@p.page>