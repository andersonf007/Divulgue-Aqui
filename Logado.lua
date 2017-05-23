local widget =  require ("widget")
local composer = require ("composer")
local scene = composer.newScene()
--local Publicacao = require("Publicacao")
--local usuarios = require("ListarUsuarios")




local ButtonScheduling -- botao de agendamento
local ButtonProfile
local ButtonPublicacao
local ButtonListar

function scene:create(event)

	local grupoCena = self.view 

	--ButtonScheduling = widget.newButton( {label="Agenda", x = display.contentWidth/2 + 5, y =display.contentHeight/2 - 150, shape = "roundedRect" , fillColor = { default={1,1,0,1}, over={1,0.1,0.7,0.4}}, onPress = realizarAgendamento } )
	--grupoCena:insert(ButtonScheduling)

	ButtonProfile = widget.newButton( {label="Perfil", x = display.contentWidth/2 + 5, y =display.contentHeight/2 - 50, shape = "roundedRect" , fillColor = { default={1,1,0,1}, over={1,0.1,0.7,0.4}}, onPress = visualizarPerfil } )
	grupoCena:insert(ButtonProfile)

	ButtonPublicacao = widget.newButton( {label="Publicação", x = display.contentWidth/2 + 5, y =display.contentHeight/2 - 100, shape = "Rect" , fillColor = { default={1,1,0,1}, over={1,0.1,0.7,0.4}}, onPress = realizarPublicacao})
	grupoCena:insert( ButtonPublicacao)

	ButtonListar = widget.newButton( {label = "Usuários", x = display.contentWidth/2 + 5, y = display.contentHeight/2, shape = "Rect" , fillColor = { default={1,1,0,1}, over={1,0.1,0.7,0.4}}, onPress = visualizarUsuarios} )
    grupoCena:insert(ButtonListar)
end

function  realizarAgendamento(event) -- toque no botao Agenda 
	-- vai para a pagina de agendamento
	if event.phase == "began" then
		composer.gotoScene("Agendamento")
	end
	--if event.phase == "ended" then
	--	print("xau")
	--end
end

function  visualizarPerfil(event) -- toque no botao Perfil 
	-- vai para a pagina de perfil
	if event.phase == "began" then
		composer.gotoScene("Perfil")
	end
	--if event.phase == "ended" then
	--	print("xau")
	--end
end

function realizarPublicacao(event)
	if event.phase == "began" then
		composer.gotoScene("Publicacao")
	end
	--if event.phase == "ended" then
	--	print("xau")
	--end
end

function visualizarUsuarios(event)
	if event.phase == "began" then
		composer.gotoScene( "ListarUsuarios" )
	end
end

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
