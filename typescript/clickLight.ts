how to use in html:

<div *ngFor="let model of regions">
<button
  nz-button
  class="pi-button-dark body-button {{ model.data.id }}"
  [ngClass]="model.active ? 'on selected-card' : 'off'"
  (click)="light(model.data.id)"
>
  <div class="text">{{ model.data.text }}</div>
</button>
<img
  class="{{ model.data.id }}Light light"
  src="{{ model.data.src }}"
  alt="{{ model.data.id }}"
/>
</div>

===========================================================================

scr/test文件夹:

 export const enum ProtocolTemplateRegion {
    Head = 'Head',
    Neck = 'Neck'
}

===========================================================================

import {ProtocolTemplateRegion} from ' scr/test';

interface RegionImageSource {
  id: ProtocolTemplateRegion;
  text: string;
  src: string;
}

export const IMAGE_SOURCES: RegionImageSource[] = [
  {
    id: ProtocolTemplateRegion.Head,
    text: 'Head',
    src: 'assets/bodyModel/head.svg',
  },
  {
    id: ProtocolTemplateRegion.Neck,
    text: 'Neck',
    src: 'assets/bodyModel/neck.svg',
  }
];

interface Activate<T extends { id: any }> {
  data: T;
  active: boolean;
}

export class ProtocolMenuComponent implements OnInit {

  regions: Activate<RegionImageSource>[] = IMAGE_SOURCES.map((s) => ({
    data: s,
    active: false,
  }));

  light(region: ProtocolTemplateRegion) {
    this.regions = this.regions.map((a) =>
      a.data.id === region ? { ...a, active: !a.active } : { ...a, active: false },
    );
  }

}

// region & regions

// ==================================


旧版本的ts:【这种写法不好】

export interface PostureRecord {
  src: string;
  type: Posture;
  active: boolean;
}
export const Postures: PostureRecord[] = [
  { src: 'assets/bedPosition-svg/HFS.svg', type: Posture.HFS, active: false },
  { src: 'assets/bedPosition-svg/FFS.svg', type: Posture.FFS, active: false },
];
export interface ModelActivateRecord {
  id: string;
  text: string;
  src: string;
  active: boolean;
}

export class ProtocolMenuComponent implements OnInit {
  postures = Postures;
  select(posture: PostureRecord) {
    this.postures = this.postures.map((s) =>
      s.src === posture.src
        ? { ...s, active: !s.active }
        : { ...s, active: false },
    );
  }
}