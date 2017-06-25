local widget =  require ("widget")
local composer = require ("composer")
local web = require ("webServiceConnection")
local scene = composer.newScene()

local ButtonProfile
local ButtonPublicacao
local ButtonListar
local tableView
--// integracao continua / treves/ ap veiou e treves
--um ambiente de execucao 
--cria uma maquina virtual mas proxima do que vc precisa
--uma maquina praticamente igual a um ambiente de producao mais nao é um ambiente de producao
-- ambiente de omologacao
-- o cliente usa o amiente de producao e nao de omologacao
-- almetar a chance de nao dar erros no ambiente de producao
function scene:create(event)

	local grupoCena = self.view 

	ButtonProfile = widget.newButton( 
		{
		label="Perfil", 
		x = display.contentWidth/2 * 0.50, 
		y =display.contentHeight/2 * 2.10,
		width = 150,
		height = 40, 
		shape = "roundedRect" , 
		fillColor = { default={1,1,0,1}, over={1,0.1,0.7,0.4}}, 
		onPress = visualizarPerfil 
		} 
	)
	grupoCena:insert(ButtonProfile)

	ButtonPublicacao = widget.newButton( 
		{
		label="Publicação", 
		x = display.contentWidth/2 * 1.50, 
		y =display.contentHeight/2 * 2.10, 
		width = 150,
		height = 40, 
		shape = "roundedRect", 
		fillColor = { default={1,1,0,1}, over={1,0.1,0.7,0.4}}, 
		onPress = realizarPublicacao})
	grupoCena:insert( ButtonPublicacao)

--[[
	tableView = widget.newTableView(
	    {
	        left = 10,
	        top = 000,
	        height = 330,
	        width = 300,
	        onRowRender = onRowRender,
	        onRowTouch = onRowTouch,
	    }
	)
	grupoCena:insert(tableView)
]]

end

function  visualizarPerfil(event) -- toque no botao Perfil 
	-- vai para a pagina de perfil
	if event.phase == "began" then
		web:recoverUserIdWS(codigoUser)
		composer.gotoScene("Perfil")
	end
end

function realizarPublicacao(event)
	if event.phase == "began" then
		composer.gotoScene("Publicacao")
	end
end

--[[

local nome = {{nome = "hey", idade = 1}, {nome = "hey2", idade = 2}}

-- Insert 40 rows
for i = 1, #nome do
    -- Insert a row into the tableView
    tableView:insertRow{
    	--isCategory = false,
    	rowHeight = 80,
    	rowColor = {default = {225,225,225}},
    	lineColor = {220,220,220}
	}
end
]]
function scene:show(event)
end

function scene:hide(event)
end


function scene:destroy(event)
end

scene:addEventListener( "create", scene ) -- adiciona o evento da funcao de criar 
scene:addEventListener( "show", scene ) -- adiciona o evento da funcao de entre 
scene:addEventListener( "hide", scene ) -- adiciona o evento da funcao de sair
scene:addEventListener( "destroy", scene )-- adiciona o evento da funcao de destruir 

return scene
