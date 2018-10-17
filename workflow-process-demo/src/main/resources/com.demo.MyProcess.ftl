
<div class="form-content one-col">
  <input type="hidden" name="processId" value="${process.id}"/>
  <div class="form-row clearfix">
    <label>Issue key:</label>
    <input type="text" name="issueKey" id="issueKey" value=""/>
    <input type="button" id="start-demo" value="Click me to start demo process"/>
  </div>
  	<#noparse>
		<script type="text/javascript">
		$("#start-demo").click(function(){
			alert('click me to start process');
			$.ajax({
			  type: "POST",
			  url: "rest/process/start",
			  success: function(data) {
			      alert('success')
			    },
			  dataType: 'jsonp',
			});
		  
		});
		</script>
	</#noparse>
</div>