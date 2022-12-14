import Foundation
import Combine
import SwiftUI
import shared

struct RandomDogView: View {
    @ObservedObject var viewmodel = ViewModels().getRandomDogGridViewModel()

    var body: some View {
        let state = ResultKs<RandomDogResponse>(viewmodel.randomDog.value!)
        switch state {
            case .error(_):
                Text("ERROR")
            case .loading:
                Text("LOADING")
            case .success(let FlowResultSuccess):
                let columns: [GridItem] = Array(
                    repeating: .init(.flexible()
                ), count: 3)
            
            ForEach(FlowResultSuccess.data!.message, id:\.self) { url in
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
        }
    }
}

//struct RandomDogView_Previews: PreviewProvider {
//	static var previews: some View {
//        RandomDogView()
//	}
//}
//
//extension RandomDogGridViewModel {
//    var dogs: AnyPublisher<RandomDogResponse, Never> {
//        get {
//            return createPublisher(self.randomDog)
//                .eraseToAnyPublisher()
//        }
//    }
//}

//final class RandomDogViewModel: ObservableObject {
//    @Published private(set) var state: FlowResult
//    let viewModel = ViewModels().getRandomDogGridViewModel()
//
//    init() {
//        let randomDog: Kotlinx_coroutines_coreStateFlow = viewModel.randomDog
//        state = randomDog.value as! FlowResult
//        (randomDog.asPublisher() as AnyPublisher<FlowResult, Never>)
//            .receive(on: RunLoop.main)
//            .assign(
//                to: &$state
//            )
//    }
//}
