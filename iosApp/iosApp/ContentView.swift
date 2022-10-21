import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewmodel = ViewModels().getRandomDogGridViewModel().asObserveableObject()

    var body: some View {
        let state = viewmodel.state
        switch true {
            case state.isSuccess:
                let columns: [GridItem] = Array(
                    repeating: .init(.flexible()
                ), count: 3)
                ForEach(state.data!.message, id:\.self) { url in
                    LazyVGrid(columns: columns){
                        if #available(iOS 15.0, *) {
                            AsyncImage(url: URL(string: url)) { image in
                                image.resizable()
                            } placeholder: {
                                ProgressView()
                            }
                            .frame(width: 240, height: 126)
                        } else {
                            Text("VERSION")
                        }
                    }
                }
            
            case state.isError:
                Text("ERROR")
            
            default:
                Text("LOADING")
        }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
