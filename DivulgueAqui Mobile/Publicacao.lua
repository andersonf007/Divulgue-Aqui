--display.setDefault("background", 0.3, 0.6, 1)
local widget =  require ("widget") -- para os botoes
local composer = require ("composer") -- para as telas
local web = require ("webServiceConnection")
local scene = composer.newScene()

local campoDescricao
local textoDescricao
local campoCategoria
local textoCategoria
local campoLocalidade
local textoLocalidade
local botaoPublicar
local texto 
local campoPublicar
local voltar

 function scene:create(event)
   print("hum")
  -- Se quiser ajustar um pouco para baixo os campos e os nomes, estar a dispor!
	  local grupoCena = self.view 
--[[
    local rect = display.newRect(0,0, display.contentWidth,display.contentHeight)
    rect.anchorX = 0
    rect.anchorY = 0
    rect:setFillColor( 3, 0.2, 0.5 )
    grupoCena:insert(rect)
]]
    titulo = display.newText({text = "Problema", x=display.contentWidth/2, y=display.contentHeight/2 - 200, native.systemFont, 80})    
    titulo:setFillColor( 1,1,0)
    titulo.isEditable = true
    titulo.size = 30
    grupoCena:insert(titulo)


    campoDescricao = display.newText({text = "Descrição", x=display.contentWidth/2, y=display.contentHeight/2 - 70, native.systemFont, 16})
    campoDescricao:setFillColor(0,1,0)
    grupoCena:insert( campoDescricao )

    campoCategoria = display.newText({text = "Categoria", x=display.contentWidth/2, y=display.contentHeight/2 - 170, native.systemFont, 16})
    campoCategoria:setFillColor(0,1,0)
    grupoCena:insert( campoCategoria )

    campoLocalidade = display.newText({text = "Local", x=display.contentWidth/2,y=display.contentHeight/2 - 120, native.systemFont, 16})
    campoLocalidade:setFillColor(0,1,0)
    grupoCena:insert( campoLocalidade )

    botaoPublicar = widget.newButton( 
        {
        label = "Publicar", 
        x = display.contentWidth/2,
        y = display.contentHeight/2 + 60, 
        native.systemFont,20,
        onPress = registrarPublicacao
        } 
    )
    
     grupoCena:insert( botaoPublicar )

    voltar = display.newImage( "botao-voltar.png", display.contentWidth/2 - 100, display.contentHeight/2 + 120)
    grupoCena:insert( voltar )

    voltar:addEventListener("touch",voltar)
end

function voltar(event)
 if event.phase == "began" then
    print("entrou no voltar")
  end
end

function registrarPublicacao( event )
	if event.phase == "began" then
		web:RegisterPublicationWS(textoLocalidade.text,textoDescricao.text,textoCategoria.text,codigoUser)
    web:recoverPublicacaoIdWS(codigoUser)
	  textoCategoria.text = ""
		textoDescricao.text = ""
		textoLocalidade.text = ""
		composer.gotoScene("Logado")
	end
end


function scene:show( event )
 
   -- local grupoCena = self.view
    local phase = event.phase
 
    if ( phase == "did" ) then
        -- Code here runs when the scene is entirely on screen
       
		
		textoCategoria = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 150, 200, 25 ) 
		textoCategoria.isEditable = true
    textoCategoria.size = 14
    textoLocalidade = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 100 , 200, 25 ) 
		textoLocalidade.isEditable = true
    textoLocalidade.size = 14
    textoDescricao = native.newTextBox( display.contentWidth/2, display.contentHeight/2 - 10, 200, 100, native.systemFont, 200)
    textoDescricao.isEditable = true
    --textoDescricao.isFontSizeScaled = true
    textoDescricao.size  = 14
		 			
    end

end
 
function scene:hide( event )
 
   -- local sceneGroup = self.view
    local phase = event.phase
 
    if ( phase == "will" ) then
        -- Code here runs when the scene is on screen (but is about to go off screen)
      display.remove(textoCategoria)
      display.remove(textoDescricao)
	    display.remove(textoDia)
	    display.remove(textoLocalidade)
	    
    end
end
 
 
-- destroy()
function scene:destroy( event )
 
    --local sceneGroup = self.view
    -- Code here runs prior to the removal of scene's view
 
end




scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )

return scene