
<div class="form-content one-col">
  <input type="hidden" name="processId" value="${process.id}"/>
  <div class="form-row clearfix">
   <form id="form" name="form">
    <label>Issue key:</label>
    <input type="text" name="issueKey" id="issueKey" value=""/>
    <input type="button" id="start-demo" value="Click me to start demo process"/>
    </form>
  </div>
  	<#noparse>
		<script type="text/javascript">
		$("#start-demo").click(function(){
			alert('click me to start process');
			$.ajax({
			  type: "POST",
			  contentType : 'application/json',
			  url: "rest/process/com.demo.MyProcess/start",
			  data: '{"issueKey":"test process variable"}',
			  success: function(data) {
			      alert('success')
			    },
			  dataType: 'jsonp',
			});
		  
		});
		</script>
	</#noparse>
</div>