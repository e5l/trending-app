//
//  ViewController.swift
//  trending-ios
//
//  Created by jetbrains on 09/07/2018.
//  Copyright © 2018 ktorio. All rights reserved.
//

import UIKit


import trending_ios

let KUnit = Trending_iosStdlibUnit()

class ViewController: UIViewController {
    let api = Trending_iosTrending()

    override func viewDidLoad() {
        super.viewDidLoad()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    @IBAction func clickAction(_ sender: Any) {
        api.top(block: { (response) -> Trending_iosStdlibUnit in
            print(response)
            return KUnit
        }) { (cause) -> Trending_iosStdlibUnit in
            print(cause)
            return KUnit
        }
    }
}
