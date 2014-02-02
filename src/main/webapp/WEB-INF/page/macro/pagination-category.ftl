
<#assign totalRecords=pa.totalRecords>
<#assign thisPage=pa.currentPage>
<#assign recordsPerPage=pa.pageSize>
<#assign totalPages=pa.totalPages>

<#macro doPagination action >
        <#if (totalRecords > recordsPerPage)>
                <div class="pagination pagination-large" style="padding-top: 30px; clear: both;">
                <#assign link = ""/>

                <#-- ------------- -->
                <#-- Previous page -->
                <#-- ------------- -->
                <ul>
                <#if (thisPage > 1)>
                        <#assign start = (thisPage - 2) * recordsPerPage/>
                        <li><a href="${action}?page=${thisPage - 1}&id=${categoryId}">&#9668;</a></li>
                </#if>
						
						
                <#if (totalPages > 10)>
                        <#-- ------------------------------ -->
                        <#-- Always write the first 3 links -->
                        <#-- ------------------------------ -->
                        
                        <#list 1 .. 3 as page>
                                <@pageLink page action/>
                        </#list>

                        <#-- ------------------ -->
                        <#-- Intermediate links -->
                        <#-- ------------------ -->
                        <#if (thisPage > 1 && thisPage < totalPages)>
                                <#if (thisPage > 5)><li><a>...</a></li></#if>

                                <#if (thisPage > 4)>
                                        <#assign min = thisPage - 1/>
                                <#else>
                                        <#assign min = 4/>
                                </#if>

                                <#if (thisPage < totalPages - 4)>
                                        <#assign max = thisPage + 2/>
                                <#else>
                                        <#assign max = totalPages - 2/>
                                </#if>

                                <#if (max >= min + 1)>
                                        <#list min .. max - 1 as page>
                                                <@pageLink page action/>
                                        </#list>
                                </#if>

                                <#if (thisPage < totalPages - 4)><li><a>...</a></li></#if>
                        <#else>
                                <li><a>...</a></li>
                        </#if>

                        <#-- ---------------------- -->
                        <#-- Write the last 3 links -->
                        <#-- ---------------------- -->
                        <#list totalPages - 2 .. totalPages as page>
                                <@pageLink page action/>
                        </#list>
                <#else>
                        <#list 1 .. totalPages as page>
                                <@pageLink page action/>
                        </#list>
                </#if>

                <#-- ------------- -->
                <#-- Next page -->
                <#-- ------------- -->
                <#if (thisPage < totalPages)>
                        <#assign start = thisPage * recordsPerPage/>
                        <li>
                        	<a href="${action}?page=${thisPage+1}&id=${categoryId}">&#9658;</a>
                        </li>
                </#if>
				</ul>
                </div>
        </#if>
</#macro>

<#macro pageLink page action>
        <#assign start = recordsPerPage * (page - 1)/>
        <#if page != thisPage>
                <#assign link><a href="${action}?page=${page}&id=${categoryId}">${page}</a></#assign></li>
        <#else>
                <#assign link><span class="current">${page}</span></#assign>
        </#if>

        <li>${link}<li>
</#macro>