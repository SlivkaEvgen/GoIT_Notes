<#import "parts/common.ftlh" as p>
<#import "parts/noteForm.ftlh" as f>
<#import "parts/message.ftlh" as m>
<@p.page>
<h3>Edit note</h3>
    <#if message??>
        <@m.errorlist />
    </#if>
<@f.editForm />
</@p.page>