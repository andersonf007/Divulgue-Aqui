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
    
      -- Se quiser ajustar um pouco para baixo os campos e os nomes, estar a dispor!
  	  local grupoCena = self.view 
      --[[
      local rect = display.newRect(0,0, display.contentWidth,display.contentHeight)
      rect.anchorX = 0
      rect.anchorY = 0
      rect:setFillColor( 3, 0.2, 0.5 )
      grupoCena:insert(rect)
      ]]
      titulo = display.newText({text = "Problema", x=display.contentWidth/2, y=display.contentHeight/2 - 220, native.systemFont, 80})    
      titulo:setFillColor( 1,1,0)
      titulo.isEditable = true
      titulo.size = 30
      grupoCena:insert(titulo)


      campoDescricao = display.newText({text = "Descrição", x=display.contentWidth/2, y=display.contentHeight/2 - 125, native.systemFont, 16})
      campoDescricao:setFillColor(0,0,0)
      grupoCena:insert( campoDescricao )
      --[[
      campoCategoria = display.newText({text = "Categoria", x=display.contentWidth/2, y=display.contentHeight/2 - 170, native.systemFont, 16})
      campoCategoria:setFillColor(0,1,0)
      grupoCena:insert( campoCategoria )
      ]]
      campoLocalidade = display.newText({text = "Local", x=display.contentWidth/2,y=display.contentHeight/2 - 175, native.systemFont, 16})
      campoLocalidade:setFillColor(0,0,0)
      grupoCena:insert( campoLocalidade )
      
      botaoPublicar = widget.newButton( 
          {
          label = "Publicar", 
          x = display.contentWidth/2 + 29,
          y = display.contentHeight/2 + 25,
          width = 96,
          height = 40,
          strokeWidth = 4,
          shape = "roundedRect" ,
          onRelease = registrarPublicacao
          } 
      )
      
      grupoCena:insert( botaoPublicar )   

      ButtonVoltar =  widget.newButton( 
      
        {
      
        label="voltar", 
        x = display.contentWidth/2 - 50, 
        y = display.contentHeight/2 + 25,
        width = 55,
        height = 40,
        shape = "roundedRect",
        onRelease = voltarTela
        }
      )   

      grupoCena:insert(ButtonVoltar)  
end

function voltarTela(event)
  
  if event.phase == "ended" then
    textoLocalidade.text = ""
    textoDescricao.text = ""
    web:recoverPublicacaoIdWS(codigoUser)
    composer.gotoScene("Logado")
  end
end

function retornoDoCodigoDeInsercaoDaPublicacao( codigo ) -- recebe o codigo que vem do web service para saber se inseriu no banco com sucesso
        
        if codigo == 204 then

            textoDescricao.text = ""
            textoLocalidade.text = ""
            web:recoverPublicacaoIdWS(codigoUser)
            alert = native.showAlert("Informação","Publicado com sucesso!", {"ok"} )
            composer.gotoScene("Logado")

        else
          alert = native.showAlert("Erro","Não foi possível publicar, verifique a sua conexão com a internet. Se o problema persistir entre em contato conosco em suporte.divulgueaqui@gmail.com", {"ok"} )
  
        end
end

function registrarPublicacao( event )

	if event.phase == "ended" then

        if textoLocalidade.text ~= "" and textoDescricao.text ~= "" then
        		web:RegisterPublicationWS(textoLocalidade.text,textoDescricao.text,codigoUser)
        else
          alert = native.showAlert("Erro","Todos os campos são obrigatórios", {"ok"} )
        end
	 end
end

function scene:show( event )
 
   -- local grupoCena = self.view
    local phase = event.phase
 
    if ( phase == "did" ) then
      --[[
  		textoCategoria = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 150, 200, 25 ) 
  		textoCategoria.isEditable = true
      textoCategoria.size = 14]]
      textoLocalidade = native.newTextField(display.contentWidth/2, display.contentHeight/2 - 150 , 200, 25 ) 
  		textoLocalidade.isEditable = true
      textoLocalidade.size = 14
      textoDescricao = native.newTextBox( display.contentWidth/2, display.contentHeight/2 - 65, 200, 100, native.systemFont, 200)
      textoDescricao.isEditable = true
      --textoDescricao.isFontSizeScaled = true
      textoDescricao.size  = 14
		 			
    end
end
 
function scene:hide( event )
 
   -- local sceneGroup = self.view
    local phase = event.phase
 
    if ( phase == "will" ) then
        
      display.remove(textoDescricao)
	    display.remove(textoLocalidade)
	    
    end
end
 
function scene:destroy( event )
end

scene:addEventListener( "create", scene )
scene:addEventListener( "show", scene )
scene:addEventListener( "hide", scene )
scene:addEventListener( "destroy", scene )

return scene